package com.demo;


import java.io.*;
import java.util.Scanner;
import java.net.URL;

public class New {
public static void main(String [] args) throws Exception{
    String un;
    int pass;

    // The name of the file to open or path.
    String fileName = "Pass.txt";

    String line = null;

    System.out.println("Welcome, please enter the username and password to read the content of the file");
    Scanner scan = new Scanner(System.in);
    System.out.println("Username?:");
    un = scan.nextLine();
    System.out.println("Password?:");
    pass = scan.nextInt();
    Class cls = Class.forName("com.demo.New");
    ClassLoader cLoader = cls.getClassLoader();
    System.out.println(cLoader.getClass());
    URL url = cLoader.getResource("com/demo/Pass.txt");
    System.out.println("Value = " + url);

    if(un.equals("123") && pass==123){
        try {
            FileReader fileReader = new FileReader(new File(url.getFile()));
            BufferedReader bf = new BufferedReader(fileReader);
            while((line= bf.readLine()) !=null){
                System.out.println(line);
        }   

        // close file after reading
        bf.close();       

    }
    catch(FileNotFoundException ex) {
        System.out.println("Unable to open file '" + fileName + "'");               
    }
    catch(IOException ex) {
        System.out.println("Error reading file '"+ fileName + "'");                   

    }
}
else {
    System.out.println("Dude, you ain't got rights to open this file");
  }
 }
}