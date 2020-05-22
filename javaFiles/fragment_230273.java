package org.myorg.hdfsdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;



public class HdfsDemo {

    public static void main(String[] args) throws IOException {

        Configuration conf = new Configuration();
        conf.addResource(new Path("/Users/miqbal1/hadoop-eco/hadoop-1.1.2/conf/core-site.xml"));
        conf.addResource(new Path("/Users/miqbal1/hadoop-eco/hadoop-1.1.2/conf/hdfs-site.xml"));
        FileSystem fs = FileSystem.get(conf);
        System.out.println("Enter the directory name :");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Path path = new Path(br.readLine());
        displayDirectoryContents(fs, path);
    }

    private static void displayDirectoryContents(FileSystem fs, Path rootDir) {
        // TODO Auto-generated method stub
        try {

            FileStatus[] status = fs.listStatus(rootDir);
            for (FileStatus file : status) {
                if (file.isDir()) {
                    System.out.println("This is a directory:" + file.getPath());
                    displayDirectoryContents(fs, file.getPath());
                } else {
                    System.out.println("This is a file:" + file.getPath());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}