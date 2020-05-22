package com.prectice;
    import java.io.FileWriter;
    import java.io.PrintWriter;
    import java.util.ArrayList;
    import java.util.List;

    public class ListOfNumbers {

     private List<Integer> list;
     private static final int SIZE = 3;

     public ListOfNumbers () {
         list = new ArrayList<Integer>(SIZE);
         for (int i = 0; i < SIZE; i++) {
             list.add(new Integer(i));
         }
     }


     static PrintWriter out;

     public void writeList() {
         //PrintWriter out=null;
         try{
         out = new PrintWriter(new FileWriter("OutFile.txt"));
         for (int i = 0; i < SIZE; i++) {
             System.out.println("Value at: " + i + " = " + list.get(i));
         }
         }catch (Exception e){
             System.out.println("IO Exception!");
         }finally {
             out.close();
             }
     }
     public static void main (String[] args){
            ListOfNumbers list = new ListOfNumbers();
            list.writeList();
          }


    }