import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class testing {
    public static void main(String[] args) {
        int n = 5;//total no of students
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Students name:");
        Student[] students = new Student[n];
        for (int i = 0; i<n; i++)
        {
            students[i] = new Student();
            students[i].name = in.nextLine();
        }
        System.out.println("Enter marks:");
        for (int i = 0; i<n; i++)
        {
            students[i].mark = in.nextInt();
        }
        Arrays.sort(students, new MarkComparator());
        for (int i = 0; i < n; i++)
        {
            System.out.println(students[i].name + " - "+ students[i].mark);
        }
    }
}

class Student {
    int mark;
    String name;
}

class MarkComparator implements Comparator {
    public int compare(Object o1,Object o2){
        Student s1=(Student)o1;
        Student s2=(Student)o2;
        if(s1.mark>=s2.mark) {
            return 1;
        } else {
            return -1;
        }
    }
}