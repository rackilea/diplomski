package com.dinesh.ritu.enterprises;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.io.File; 
import java.io.FileNotFoundException;
/*Write a program to reverse the lines of a file and also to reverse the order of the words in each line of the file. 
Use ArrayLists to help you. The program inputs the name of the file and writes the reversed output to standard out. 
In each line of output, the words printed out are separated by single spaces.*/
/*
 * I have modify your code , hope your problem got solved with these changes :: Happy Coding 
 */
public class Homework3 {

   public static void main(String[] args) {
      try {
         Scanner scan = new Scanner(new File("input.txt"));
        //You have to scan the file again as after completing the first task the file was closed , below line will help you to run both the method  
       Scanner scan1 = new Scanner(new File("input.txt")); 
         reverseLine(scan);
         reverseWord(scan1);
         scan.close();
      } catch (FileNotFoundException ex) {
         System.out.println("An error has occured.");
      }
   }

   public static void reverseLine(Scanner scan) { //Reverses the lines of the file
      ArrayList<String> line = new ArrayList<String>();
      while (scan.hasNextLine())  {
         line.add(scan.nextLine());
      }
      for(int i = line.size() - 1; i>=0; i--) {
         System.out.println(line.get(i));
      }
      System.out.println("---------"+"Method reverseLine Ended Successfully");
   }
    public static void reverseWord(Scanner scan) { //Reverses the words of the file
      ArrayList<String> word = new ArrayList<String>();
      while (scan.hasNext())  {
         word.add(scan.next());
      }
      //Added new code for reversing the words hope this is what you want ?? Else let me know 
      Collections.reverse(word);
      System.out.println(word);
  }
}