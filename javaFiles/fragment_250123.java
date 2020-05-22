import java.io.BufferedReader;
     import java.io.FileReader;
     import java.util.Scanner;
     import java.io.File;
     ...............
     FileReader f=new FileReader(new File(fileName));
     BufferedReader bf=new BufferedReader(f);
     Scanner sc=new Scanner(bf);