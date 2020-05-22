import org.apache.commons.compress.archivers.zip.*;
import org.apache.commons.compress.parallel.InputStreamSupplier;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipMain {

static ParallelScatterZipCreator scatterZipCreator = new ParallelScatterZipCreator();
static ScatterZipOutputStream dirs;

static {
    try {
        dirs = ScatterZipOutputStream.fileBased(File.createTempFile("java-zip-dirs", "tmp"));
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) throws IOException {
    String sourceFolder = "/Users/<user>/Desktop/";
    String zipFilePath = "/Users/<user>/Desktop/Desk.zip";
    String fileTypesToBeAddedToZip = "txt";
    zip(sourceFolder, zipFilePath, fileTypesToBeAddedToZip);
    unzip(zipFilePath, sourceFolder + "/unzip/");
}

private static void zip(String sourceFolder, String zipFilePath, String fileTypesToBeAddedToZip) throws IOException {
    OutputStream outputStream = null;
    ZipArchiveOutputStream zipArchiveOutputStream = null;
    try {

        File srcFolder = new File(sourceFolder);
        if (srcFolder.isDirectory()) {
            // uncomment following code if you want to add all files under srcFolder
            //Iterator<File> fileIterator = Arrays.asList(srcFolder.listFiles()).iterator();
            Iterator<File> fileIterator = FileUtils.iterateFiles(srcFolder, new String[]{fileTypesToBeAddedToZip}, true);

            File zipFile = new File(zipFilePath);
            zipFile.delete();
            outputStream = new FileOutputStream(zipFile);

            zipArchiveOutputStream = new ZipArchiveOutputStream(outputStream);
            zipArchiveOutputStream.setUseZip64(Zip64Mode.AsNeeded);

            int srcFolderLength = srcFolder.getAbsolutePath().length() + 1;  // +1 to remove the last file separator

            while (fileIterator.hasNext()) {
                File file = fileIterator.next();

                // uncomment following code if you want to add all files under srcFolder
                //if (file.isDirectory()) {
                //        continue;
                //    }

                String relativePath = file.getAbsolutePath().substring(srcFolderLength);


                InputStreamSupplier streamSupplier = () -> {
                    InputStream is = null;
                    try {
                        is = Files.newInputStream(file.toPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return is;
                };
                ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(relativePath);
                zipArchiveEntry.setMethod(ZipEntry.DEFLATED);
                scatterZipCreator.addArchiveEntry(zipArchiveEntry, streamSupplier);
            }
            scatterZipCreator.writeTo(zipArchiveOutputStream);
            }
            if (zipArchiveOutputStream != null) {
                zipArchiveOutputStream.close();
            }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (outputStream != null) {
            outputStream.close();
        }
    }
}

private static void unzip(String zipFilePath, String destDir) {
    File dir = new File(destDir);
    // create output directory if it doesn't exist
    if (!dir.exists()) {
        dir.mkdirs();
    } else {
        dir.delete();
    }

    FileInputStream fis;
    //buffer for read and write data to file
    byte[] buffer = new byte[1024];
    try {
        fis = new FileInputStream(zipFilePath);
        ZipInputStream zis = new ZipInputStream(fis);
        ZipEntry ze = zis.getNextEntry();
        while (ze != null) {
            String fileName = ze.getName();

            File newFile = new File(destDir + File.separator + fileName);

            System.out.println("Unzipping to " + newFile.getAbsolutePath());

            //create directories for sub directories in zip
            String parentFolder = newFile.getParent();
            File folder = new File(parentFolder);
            folder.mkdirs();

            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            //close this ZipEntry
            zis.closeEntry();
            ze = zis.getNextEntry();
        }
        //close last ZipEntry
        zis.closeEntry();
        zis.close();
        fis.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

}
}