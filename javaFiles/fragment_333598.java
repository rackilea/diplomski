package sample;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class Calc {

    private int totalFolder = 0, totalFile = 0;
    private static int counter = 0;
    private final ObservableList<PieChart.Data> pieChartData;
    private ArrayList<PieChart.Data> pieChartData2;//EDIT: here you don't need an ObservableList, a simple ArrayList will do it
    private long filesInRoot = 0;
    Path fileInRoot;

    //added a constructor to receive a reference of the Observable list
    public Calc(ObservableList<PieChart.Data> pieChartData) {
        this.pieChartData = pieChartData;//EDIT: when you set this.pieChartData = pieChartData2 the parameter would be ignored...
        pieChartData2 = new ArrayList<PieChart.Data>();
    }

    public void calcSubfoldersSize(String sPath) { //replaces public void main(String args)
        File nativeFile = new File(sPath);
        File file = new File(nativeFile.toString());

        String[] files = file.list();
        Path path;

        filesInRoot = 0;
        if (file.isDirectory()) {
            for (int i = 0; i <= files.length - 1; i++) {
                path = Paths.get(files[i]);
                file = path.toFile();
                counter++;
            }

            String[] paths = new String[counter];
            for (int i = 0; i <= files.length - 1; i++) {
                path = Paths.get(files[i]);
                file = path.toFile();
                paths[i] = file.toString();
            }

            for (int i = 0; i != counter; i++) {

            }
            for (int i = 0; i + 1 <= paths.length; i++) {
                try {
                    Calc size = new Calc(pieChartData); //the only line changed in the method
                    long fileSizeByte = size.getFileSize(new File(nativeFile.toString() + "\\" + paths[i]));
                    add(paths[i], fileSizeByte, i, paths.length);
                }
                catch (Exception e) {
                    fileInRoot = Paths.get(nativeFile.toString() + "\\" + paths[i]);
                    filesInRoot = filesInRoot + fileInRoot.toFile().length();
                }
            }
            if (filesInRoot != 0) {
                add("Files in Directory", filesInRoot, 1, 100);
                pieChartData2.add(new PieChart.Data("Files in Directory", filesInRoot));
                System.out.println(filesInRoot);
            }
        }

        //EDIT: let this part be executed by the fx-application thread:
        Platform.runLater(() -> pieChartData.addAll(pieChartData2));
    }

    //let add update the observable list
    public void add(String loc, long size, int i, int aim) {
        pieChartData2.add(new PieChart.Data(loc, size));//EDIT: the error seems to occur here because pieChartData2 was null (but I'm not sure why there was no exception shown...; probably because it's executed in the task...) 
    }

    public long getFileSize(File folder) {
        long foldersize = 0;

        totalFolder++;
        //          System.out.println("Folder: " + folder + "  (Source: getFileSize)");
        File[] filelist = folder.listFiles();
        //          System.out.println(folder.listFiles());

        for (int i = 0; i < filelist.length; i++) {
            if (filelist[i].isDirectory()) {
                foldersize += getFileSize(filelist[i]);
            }
            else {
                totalFile++;
                foldersize += filelist[i].length();
            }
        }

        return foldersize;

    }

    public int getTotalFolder() {
        return totalFolder;
    }

    public int getTotalFile() {
        return totalFile;
    }
}