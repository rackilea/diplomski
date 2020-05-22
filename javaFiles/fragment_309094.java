package exmaple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Finder {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        int n = userInput.nextInt();
        int m = userInput.nextInt();


        ArrayList<String> names = new ArrayList<String>(n);
        ArrayList<Integer> numbers;

        ArrayList<ArrayList<Integer>> holderOfMarksArayList = new ArrayList<ArrayList<Integer>>();


        for(int i = 0; i<n; i++) {
            System.out.println("Enter name of contentant.");
            String name = userInput.next();
            names.add(name);
            numbers = new ArrayList<Integer>(m);
            for(int j = 0; j<m; j++) {
                System.out.println("Enter score.");
                numbers.add(userInput.nextInt());
            }
            holderOfMarksArayList.add(numbers);
        }

        int counter = 0;
        for(String name : names) {
            numbers = holderOfMarksArayList.get(counter);
            Collections.sort(numbers);
            int maxScore = numbers.get(numbers.size() - 1);
            int minScore = numbers.get(0);
            System.out.println(name +",  Max Score = " + maxScore + " Min Score = " + minScore);
            counter++;
        }
        userInput.close();

    }

}