import java.util.ArrayList;

public class Chap11Part1 {

    public static void main(String[] args) {
        double average;
        int total = 0;
        ArrayList<Integer> grades = new ArrayList<Integer>();
        grades.add(78);
        grades.add(84);
        grades.add(90);
        for (int i = 0; i < grades.size(); ++i)
            total += grades.get(i);
        average = total / grades.size();
        System.out.println("The average is " + average);
    }
}