package com.tobee.tests.inout;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CheckBounsFromFile {
    public static void main(String[] args) {
        String name, phrase, grade;
        double bonus = 0;
        int salary = 0;
        BufferedReader readFile = null;
        try {
            readFile = new BufferedReader(new FileReader("resource/aa/employeeBonus.txt"));

            while ((phrase = readFile.readLine()) != null) {
                //System.out.println(phrase);

                StringTokenizer stTok = new StringTokenizer(phrase, " \t");

                name = stTok.nextToken();

                salary = Integer.valueOf(stTok.nextToken()).intValue();

                grade = stTok.nextToken();

                if(grade!= null && !grade.equals(""))
                {
                    if (grade.equals("1")) {
                        bonus = salary / 0.03;
                    } else if (grade.equals("2")) {
                        bonus = salary / 0.08;

                    } else if (grade.equals("3")) {
                        bonus = salary / 0.20;
                    }

                    System.out.printf("name[%s]salary[%d]Bonus[%f] \n",name, salary, bonus);
                }

            }

        } catch (IOException e) {
            System.out.println("Problem reading file.");
            System.err.println("IOException: " + e.getMessage());
        }
        finally
        {
            try {
                readFile.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}