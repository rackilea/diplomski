package tes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ImageCompression {

    public static void main(String args[]) throws FileNotFoundException {

        ImageCompression compression = new ImageCompression();
        compression.readandwriteFile();
    }

    public void readandwriteFile() throws FileNotFoundException {

        String inputFilePath = "C:\\Users\\yc03ak1\\Desktop\\A.txt";
        String outputFilePath = "C:\\Users\\yc03ak1\\Desktop\\B.txt";

        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);

        if (!inputFile.exists() || !outputFile.exists()) {
            throw new FileNotFoundException("file not found");
        }

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
            bufferedReader = new BufferedReader(new FileReader(inputFile));
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        String line = "";
        String previousLine = "";
        int counter = 0;
        int i =0; 
        try {
            while ((line = bufferedReader.readLine()) != null) {

                if (i==0) {

                        previousLine = line;
                        counter++;
                        i++;
                        continue;

                }


                if (previousLine.equals(line)) {
                     counter++;
                }else {

                    if (counter>1) {
                        bufferedWriter.write(previousLine +" x"+counter);
                    }else {
                        bufferedWriter.write(previousLine);
                    }
                    bufferedWriter.newLine();
                    counter=1;
                }
                previousLine = line;


            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedWriter != null) {

                try {
                        bufferedWriter.close();
                }catch(IOException e) {
                    e.printStackTrace();
                }
            }   

    }




    }

}