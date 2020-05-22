package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileSearch {

    public void parseFile(String fileName,String searchStr) throws FileNotFoundException{
        Scanner scan = new Scanner(new File(fileName));
        while(scan.hasNext()){
            String line = scan.nextLine().toLowerCase().toString();
            if(line.contains(searchStr)){
                System.out.println(line);
            }
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        FileSearch fileSearch = new FileSearch();
        fileSearch.parseFile("src/main/resources/test.txt", "am");
    }

}


test.txt contains:
I am a legend
Hello World
I am Ironman

Output:
i am a legend
i am ironman