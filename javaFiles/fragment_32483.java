package de.scrum_master.app;

import java.io.File;

public class FileLoophole extends File {
    public FileLoophole(String filename) {
        super(filename);
    }

    public static void main(String[] args) {
        new File("file.txt");
        new FileLoophole("loophole.txt");
    }
}