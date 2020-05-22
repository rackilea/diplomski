package test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Searcher {
    public static void main(String[] args) {
        ArrayList<File> roots = new ArrayList<File>();
        roots.addAll(Arrays.asList(File.listRoots()));


        for (File file : roots) {
            new Searcher(file.toString().replace('\\', '/')).search();
        }
    }

    private String root;

    public Searcher(String root) {
        this.root = root;
    }

    public void search() {
        System.out.println(root);
        File folder = new File(root);
        File[] listOfFiles = folder.listFiles();
        if(listOfFiles == null) return;  // Added condition check
        for (File file : listOfFiles) {
            String path = file.getPath().replace('\\', '/');
            System.out.println(path);
            if (file.isDirectory()) {
                new Searcher(path + "/").search();
            }
        }
    }
}