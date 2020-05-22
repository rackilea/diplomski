package com.mycompany.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.log4j.Logger;

public class FileZipper {

    private static final Logger LOGGER = Logger.getLogger(OldFileZipper.class);
    private String destinationZipFile;
    private String sourceDirectory;

    List<String> fileList;
    private File zipFile;

    public File getZipFile() {
        return zipFile;
    }

    /**
     * Zips a source directory into the destination zip file
     * 
     * @param source
     * @param destination
     */
    FileZipper(String source, String destination) {
        LOGGER.info("Zipping source directory: "+source);
        LOGGER.info("To destination zip file:  "+destination);
        this.destinationZipFile = destination;
        this.sourceDirectory = source;
        fileList = new ArrayList<String>();
        generateFileList(new File(sourceDirectory));
        compressDirectoryContentsToZip(sourceDirectory, destinationZipFile);
    }

    /**
     * Traverse a directory and get all files, and add the file into fileList
     * 
     * @param node
     *            file or directory
     */
    public void generateFileList(File node) {

        // add file only
        if (node.isFile()) {
            fileList.add(generateZipEntry(node.getAbsoluteFile().toString()));
        }

        if (node.isDirectory()) {
            if(node.toString() != sourceDirectory) {
                fileList.add(generateZipEntry(node.getAbsoluteFile().toString()));
            }
            String[] subNodes = node.list();
            for (String filename : subNodes) {
                generateFileList(new File(node, filename));
            }
        }

    }

    /**
     * Compress a directory to a zip file
     * @param sourceDirectory
     * @param destinationZipFile
     */
    public void compressDirectoryContentsToZip(String sourceDirectory, String destinationZipFile) {

        this.zipFile = new File(destinationZipFile);

        byte[] buffer = new byte[4096];

        try {

            FileOutputStream fos = new FileOutputStream(destinationZipFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ZipArchiveOutputStream zos = new ZipArchiveOutputStream(bos);
            zos.setMethod(ZipArchiveOutputStream.DEFLATED);
            zos.setLevel(0);
            LOGGER.info("Zipping to : " + destinationZipFile);

            for (String entry : this.fileList) {
                long fileSizeInBytes = new File(sourceDirectory + File.separator + entry).length();

                if(new File(sourceDirectory + File.separator + entry).isFile()) {
                    LOGGER.info("File Added : " + entry + " ("+String.valueOf(fileSizeInBytes)+" bytes)");
                    ZipArchiveEntry ze = new ZipArchiveEntry(entry);
                    zos.putArchiveEntry(ze);
                    FileInputStream in = new FileInputStream(sourceDirectory
                            + File.separator + entry);
                    int len;
                    while ((len = in.read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }

                    in.close();
                    zos.closeArchiveEntry();

                } else if(new File(sourceDirectory  + File.separator + entry).isDirectory()) {
                    LOGGER.info("Directory Added : " + entry);
                    ZipArchiveEntry ze = new ZipArchiveEntry(entry+File.separator);
                    zos.putArchiveEntry(ze);
                    zos.closeArchiveEntry();
                } else {
                    LOGGER.warn("Not a file or directory: "+entry);
                }
            }

            zos.close();

            LOGGER.info("Zipping completed successfully");
        } catch (IOException ex) {
            LOGGER.error(ex);
            System.exit(1);
        }
        LOGGER.info("Generated zip file: "+ destinationZipFile);
    }


    /**
     * Format the filename for archiving by removing the path
     * of the source directory
     * 
     * @param file
     * @return
     */
    private String generateZipEntry(String file) {
        LOGGER.debug("Stripping '"+file+"' to '"+file.substring(sourceDirectory.length() + 1, file.length())+"'");
        return file.substring(sourceDirectory.length() + 1, file.length());
    }

}