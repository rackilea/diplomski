import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;
//for Excel ark
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;

public class MaxDuplicateWordCount {

    public Map<String, Integer> getWordCount(String fileName) {

        FileInputStream fis = null;
        DataInputStream dis = null;
        BufferedReader br = null;
        Map<String, Integer> wordMap = new HashMap<String, Integer>();

        try {
            fis = new FileInputStream(fileName);
            dis = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(dis));
            String line = null;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, " ");
                while (st.hasMoreTokens()) {
                    String tmp = st.nextToken().toLowerCase();
                    if (wordMap.containsKey(tmp)) {
                        wordMap.put(tmp, wordMap.get(tmp) + 1);
                    } else {
                        wordMap.put(tmp, 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (Exception ex) {
            }
        }
        return wordMap;
    }

    public List<Entry<String, Integer>> sortByValue(Map<String, Integer> wordMap) {

        Set<Entry<String, Integer>> set = wordMap.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                return (o2.getValue()).compareTo(o1.getValue());
            }


        });
        return list;
    }

    final static String WORKSPACE = "C:/testfolder/";

    private static void createOutputFolder(String outputFolderName) {
        File outputDirectory = new File(WORKSPACE + outputFolderName);

        if (!outputDirectory.exists()) {
            try {
                outputDirectory.mkdir();
            } catch (Exception e) {
            }
        }
    }

    private static void exlCreator() {

        String outputFolder = "output/";
        String fileName, fileNameWPathInput;
        int serialNumber = 1;
        createOutputFolder(outputFolder);

        MaxDuplicateWordCount mdc = new MaxDuplicateWordCount();
        File folder = new File(WORKSPACE);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                fileName = listOfFiles[i].getName();
                fileNameWPathInput = WORKSPACE + fileName;
                Map<String, Integer> wordMap = mdc.getWordCount(fileNameWPathInput);
                List<Entry<String, Integer>> list = mdc.sortByValue(wordMap);
                String fileNameWPathOutput = WORKSPACE + outputFolder +
                        fileName.substring(0, fileName.length() - 4)
                        + "output.xls";
                try {
                    HSSFWorkbook workbook = new HSSFWorkbook();
                    HSSFSheet sheet = workbook.createSheet("ResultSheet");

                    HSSFRow rowhead = sheet.createRow((short) 0);
                    rowhead.createCell(0).setCellValue("Serial No.");
                    rowhead.createCell(1).setCellValue("Word");
                    rowhead.createCell(2).setCellValue("Count");

                    for (Map.Entry<String, Integer> entry : list) {
                        HSSFRow row = sheet.createRow((short) serialNumber);
                        row.createCell(0).setCellValue(serialNumber);
                        row.createCell(1).setCellValue(entry.getKey());
                        row.createCell(2).setCellValue(entry.getValue());
                        serialNumber++;
                    }
                    FileOutputStream fileOut = new FileOutputStream(fileNameWPathOutput);
                    workbook.write(fileOut);
                    fileOut.close();
                    serialNumber = 1;
                    System.out.println(fileNameWPathOutput + " is created");

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {
        exlCreator();
    }
}