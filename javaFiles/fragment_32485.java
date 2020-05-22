package de.scrum_master.app;

import java.io.File;

public class Application {
    private class FileLoophole extends File {
        public FileLoophole(String filename) {
            super(filename);
        }
    }

    public static void main(String[] args) {
        new File("file.txt");
        new Application().new FileLoophole("loophole.txt");
    }
}