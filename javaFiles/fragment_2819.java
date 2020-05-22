package com.test;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;


public class SearchInFilesAndDirectory {

    private static int lineNumber = 0;

    private static final String FOLDER_PATH = "path_to_file";

    public static void main(String[] args) {

        File dir = new File(FOLDER_PATH);

        List<File> files = (List<File>) FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, DirectoryFileFilter.DIRECTORY);

        for (File file : files) {

            if (file.isFile()) {

                try (BufferedReader br = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8)) {

                    String line;
                    while ((line = br.readLine()) != null) {
                        lineNumber++;
                        if (line.contains("word")) {
                            System.out.println("Keyword found in " + file.toPath() + " at line " + lineNumber + ".\n" + line.trim());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}