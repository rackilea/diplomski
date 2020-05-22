import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import packagename.Bridge;
import packagename.Farmer;

public class MainP2 {

    public static void main(String[] args) {
        System.out.println("Question 2.");
        //File reading
        boolean success = false;    //looping file input
        int N=0,S=0;
        String[] input;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter file name eg input.txt: ");
        while (!success) {  //loop until a valid file is given
            try {
                String f = in.nextLine();
                Scanner file = new Scanner(new File(f));    //Throws file not found exception
                try {
                    //split by space
                    input = file.nextLine().split("\\s+");
                    //set number of north and south farmers
                    N = Integer.parseInt(input[0].replaceAll("[^0-9]+",""));    
                    S = Integer.parseInt(input[1].replaceAll("[^0-9]+",""));
                    success = true; //no exception thrown, all went well, break loop
                } catch (NoSuchElementException e) {System.out.println("File was empty or invalid! Please enter a valid file.");}
                file.close();
            } catch (FileNotFoundException e) { System.out.println("File not found! Please enter a valid file.");}
        }
        in.close();
        //end file reading

        Bridge bridge = new Bridge();   //create our bridge
        Farmer[] f = new Farmer[N+S];   //array of Farmers
        //create North farmers
        for (int i=0; i<N; i++) {
            f[i] = new Farmer("N_Farmer"+(i+1),"North",bridge);
        }
        //create South farmers
        for (int i=N; i<S+N; i++) {
            f[i]= new Farmer("S_Farmer"+(i-N+1),"South",bridge);
        }

        //start all farmers
        for (int i=0;i<S+N;i++) {
            f[i].start();   //start Farmer Threads. Farmers can run start, as Farmer extends thread
        }
    }

}