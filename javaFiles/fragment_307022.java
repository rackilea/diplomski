import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nudanesh
 */
public class Library  {

    boolean downloaded = false;
    Thread t;
    int waitTime = 0;
    String baseLoc = "";
    int size = 1024, ByteWritten = 0;
    URL url;
    URLConnection uCon = null;
    String folderLoc = "", file = "firstFile.csv";
    File loc;
    private OutputStream outStream;
    private InputStream is=null;
    private byte[] buf;
    private int ByteRead;
    private int FolderInUrl = 4;
    private boolean rootFolder = true;
    private File resultFile;
    private FileOutputStream fileResult;
    private XSSFWorkbook workbookResult;
    private XSSFSheet sheetResult;
    private int updateExcelRowNum = -1;
    private int updateExcelColNum = -1;
    String date;
    private int waitLimit = 900000;

    Library() {
        /*System.out.print(Calendar.getInstance().toString());
         Date d=new Date();
         String date=d.toString();
         System.out.println(date);*/

        //t = new Thread(this);
       // t.start();

        date = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
        System.out.print(date);
        baseLoc = date + "/";
        WriteDataToExcel();
        baseLoc += "Business Reports/";
        createRowExcel(updateExcelRowNum);
        updateRowColExcel(updateExcelRowNum, updateExcelColNum, "Report Name");
        updateRowColExcel(updateExcelRowNum, updateExcelColNum, "Path");
        updateRowColExcel(updateExcelRowNum, updateExcelColNum, "Status");
        updateExcel();
    }

    public void setLocation(String a, String b) {
        file = a;
        file += ".csv";
        folderLoc = baseLoc + getFolderPath(b);

   // System.out.println("File Name: "+file);
        // System.out.println("Folder loc: "+folderLoc);
    }

    public String getFolderPath(String b) {
        String path = "";
        try {
            System.out.println("path" + b);
            path = b;
            // path = java.net.URLDecoder.decode(b, "UTF-8");
            String p[] = path.split("/");
            path = "";
            for (int i = FolderInUrl; i < p.length - 1; i++) {
                rootFolder = false;
                p[i] = removeSpacesAtEnd(p[i]);

                path = path + p[i] + "/";
            }

        } catch (Exception ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
        return path;
    }

    public void downloadFile(String urlString) {
        // System.out.println("Started");
        try {
            url = new URL(urlString);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loc = new File(folderLoc);
            if (!loc.exists()) {
                loc.mkdirs();
            }


            outStream = new BufferedOutputStream(new FileOutputStream(folderLoc + file));
            uCon = url.openConnection();
        uCon.setReadTimeout(waitLimit);
                is = uCon.getInputStream();
               downloaded=true;
            buf = new byte[size];

            while ((ByteRead = is.read(buf)) != -1) {
                System.out.println("while executing" + ByteRead);
                outStream.write(buf, 0, ByteRead);
                ByteWritten += ByteRead;
            }

            //System.out.println("Downloaded" + ByteWritten);
            resetCounters();
            createRowExcel(updateExcelRowNum);
            updateRowColExcel(updateExcelRowNum, updateExcelColNum, file);
            updateRowColExcel(updateExcelRowNum, updateExcelColNum, folderLoc);
            if (ByteWritten < 1000) {
                updateRowColExcel(updateExcelRowNum, updateExcelColNum, "Downloaded ");
            } else {
                updateRowColExcel(updateExcelRowNum, updateExcelColNum, "Downloaded ");
            }
            updateExcel();
        } catch (Exception e) {
            System.out.println("error catch" + e);
            resetCounters();
            createRowExcel(updateExcelRowNum);
            updateRowColExcel(updateExcelRowNum, updateExcelColNum, file);
            updateRowColExcel(updateExcelRowNum, updateExcelColNum, folderLoc);
            updateRowColExcel(updateExcelRowNum, updateExcelColNum, "Rejected the Download after waiting " + (waitLimit / 60000) + " minutes");
            updateExcel();
            waitTime = 0;
        } finally {
            try {
                System.out.println("Error in streams");
                if(downloaded)
                is.close();
                outStream.close();
                downloaded= false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void moveToFolder(String reportName, String path) {

        try {
            File repo = new File(folderLoc + "/" + reportName + ".csv");
            path = folderLoc + "/" + path;
            File pathFolder = new File(path);
            if (!pathFolder.exists()) {
                pathFolder.mkdirs();
            }
            pathFolder = new File(path + reportName + ".csv");
            System.out.println("Path=" + pathFolder.getAbsolutePath() + "\nReport path=" + repo.getAbsolutePath());
            System.out.println("Source" + repo.getAbsolutePath());

            //System.out.println("Status" + repo.renameTo(new File(pathFolder.getAbsolutePath())));
            System.out.println("Status" + Files.move(repo.toPath(), new File(pathFolder.getAbsolutePath()).toPath(), REPLACE_EXISTING));
//Files.

        } catch (Exception e) {
            System.out.println("error while moving" + e);
        }

    }

    public String changeSpecialCharacters(String report) {

        report = report.replaceAll(":", "_");
        return report;
    }

    public String removeSpacesAtEnd(String inputPath) {

        for (int i = inputPath.length() - 1; i >= 0; i--) {
            if (inputPath.charAt(i) != ' ') {
                break;
            } else {
                System.out.println("Before string is" + inputPath);
                inputPath = inputPath.substring(0, i);
                System.out.println("AFter string is" + inputPath);
            }
        }

        return inputPath;
    }

    public void WriteDataToExcel() {

        try {
            // file = new FileInputStream(new File("config.xlsx"));

            //   File resultFolder = new File("Results");
            //   if (resultFolder.exists()) {
            //       deleteDirectory(resultFolder);
            //   }
            // resultFolder.mkdirs();
            if (!new File(baseLoc).exists()) {
                new File(baseLoc).mkdirs();
            }
            resultFile = new File(baseLoc + "Reports info " + date + ".xlsx");
            System.out.println("Path" + resultFile.getAbsolutePath());
            resultFile.createNewFile();
            // rFilePath = resultFile.getAbsolutePath();

            fileResult = new FileOutputStream(resultFile);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Get the workbook instance for XLS file
        //      System.out.println("file success");
        XSSFWorkbook workbook = null;

        try {

            workbookResult = new XSSFWorkbook();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Opening the browser");
        //Get first sheet from the workbook

        sheetResult = workbookResult.createSheet();
        //sheetResult.set
        //Get iterator to all the rows in current sheet

        //Get iterator to all cells of current row
        //ar.add(folderLocation);
        //  ar.add(firefoxProfileLocation);
    }

    public void updateExcel() {
        try {
            //fileResult.close();

            fileResult = new FileOutputStream(resultFile);
            workbookResult.write(fileResult);
            fileResult.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void createRowExcel(int num) {
        updateExcelRowNum++;
        num = updateExcelRowNum;
        sheetResult.createRow(num);

    }

    public void updateRowColExcel(int rnum, int cnum, String value) {
        updateExcelColNum++;
        cnum = updateExcelColNum;
        sheetResult.getRow(rnum).createCell(cnum);
        XSSFCell cell = sheetResult.getRow(rnum).getCell(cnum);
        cell.setCellValue(value);

    }

    public void updateColumn(int rnum, int cnum, String value) {
        XSSFCell cell = sheetResult.getRow(rnum).getCell(cnum);
        cell.setCellValue(value);

    }

    public void resetCounters() {
        updateExcelColNum = -1;

    }

 /*   @Override
    public void run() {
        while (true) {
            if (true) {
                waitTime += 1000;
System.out.println(waitTime);
                if (waitTime > waitLimit) {
                    try {
                        is.close();
                        outStream.close();
                    //downloaded=false;
                        // cancelDownload=true;
                    } catch (Exception ex) {
                        Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }

        }
    }*/

}