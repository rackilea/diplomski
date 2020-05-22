import java.io.*;
 import java.util.*;

 public class Class{

     public static void main (String[] args) {
     ProcessBuilder pb = null;
     Process p = null;

     try {
     ProcessBuilder pb = new ProcessBuilder("C:\\....\\c.exe", "C:\\.....\\w.par");

     Process p = pb.start();

     BufferedReader stdInput = new BufferedReader(newInputStreamReader(p.getInputStream()));
     } catch (IOException | ProcessException e) {
         System.err.println("Some error message"); 
     }