import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class BasicCompressFileService {

    private List<String> fileList; // Stores list of file names.
    private static final String OUTPUT_ZIP_FILE = "File.zip"; // Output zip base name
    private String SOURCE_FOLDER; // Stores source folder for Utils.

    /**
     * Funtion to zip directory. Zip files contents will be fetched from inputDir and
     * Output will be stored in outputDir. The zip file will be split and each chunck 
     * will not be more that provided maxSize.
     */
    public void compressFolderWithMaxLimit(String inputDir, String outputDir, Long maxSize) {
        setupZipUtils();
        SOURCE_FOLDER = inputDir;
        generateFileList(new File(inputDir));
        try {
            final int BUFFER = (int) (maxSize * 1048576); // max buffer to create a zip file.
            String directoryPath = outputDir;
            if (!directoryPath.endsWith("/")) {
                directoryPath = directoryPath + "/";
            }
            String inDirectoryPath = inputDir;
            if (!inDirectoryPath.endsWith("/")) {
                inDirectoryPath = inDirectoryPath + "/";
            }
            byte fileRAW[] = new byte[BUFFER];
            FileInputStream entryFile;
            int count = 1;
            for (String aFile : fileList) {
                entryFile = new FileInputStream(inDirectoryPath + aFile);
                int len;
                while ((len = entryFile.read(fileRAW)) > 0) {
                    FileOutputStream fos = new FileOutputStream(directoryPath
                            + OUTPUT_ZIP_FILE.toLowerCase().replace(".zip", (count++) + ".zip").toUpperCase());
                    ZipOutputStream zos = new ZipOutputStream(fos);
                    zos.putNextEntry(new ZipEntry(aFile));
                    zos.write(fileRAW, 0, len);
                    zos.closeEntry();
                    zos.close();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Setup zip Utils.
     */
    public void setupZipUtils() {
        fileList = new ArrayList<String>();
    }

    /**
     * Generate File list.
     * @param node
     */
    public void generateFileList(File node) {
        // add file only
        if (node.isFile()) {
            fileList.add(generateZipEntry(node.toString()));
        }

        if (node.isDirectory()) {
            String[] subNote = node.list();
            for (String filename : subNote) {
                generateFileList(new File(node, filename));
            }
        }
    }

    /**
     * Generated the Zip entry.
     * @param file
     * @return
     */
    private String generateZipEntry(String file) {
        return file.substring(SOURCE_FOLDER.length() + 1, file.length());
    }

    @Override
    public void decompressFolderWith(String inputDir, String outputDir) {
        String outputFolder = outputDir;
        if (!outputFolder.endsWith("/")) {
            outputFolder = outputFolder + "/";
        }

        String intputFolder = inputDir;
        if (!intputFolder.endsWith("/")) {
            intputFolder = intputFolder + "/";
        }

        setupZipUtils();
        generateFileList(new File(intputFolder));
        Collections.sort(fileList);
        for (int x = 0; x < fileList.size(); x++)
            try {
                unzipFile(new FileInputStream(intputFolder + fileList.get(x)), outputFolder);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
    }

    /**
     * Unzips the file in provided folder.
     * @param in
     * @param outputFolder
     * @throws IOException
     */
    private void unzipFile(InputStream in, String outputFolder) throws IOException {
        ZipInputStream is = new ZipInputStream(in);

        for (ZipEntry entry = null; (entry = is.getNextEntry()) != null;) {
            File newFile = new File(outputFolder + entry.getName());
            newFile.getParentFile().mkdirs();
            OutputStream os = new BufferedOutputStream(new FileOutputStream(newFile, true));
            try {
                final int bufferSize = 1024;
                byte[] buffer = new byte[bufferSize];
                for (int readBytes = -1; (readBytes = is.read(buffer, 0, bufferSize)) > -1;) {
                    os.write(buffer, 0, readBytes);
                }
                os.flush();
            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                os.close();
            }
        }
        is.close();
    }

}