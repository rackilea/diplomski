package averageage;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class AverageAge {

public static void main(String[] args) {
    int Avg = 0;
    int n = Integer
            .parseInt(JOptionPane
                    .showInputDialog("Enter number of how many people are in the classroom:"));
    n = n - 1;
    // * n is defined for the number of students-1 because a list starts at
    // 0.
    List<Integer> Ages = new ArrayList<>();
    // *Defined the list.
    for (int i = 0; i <= n; i++) {
        Ages.add(Integer.parseInt(JOptionPane
                .showInputDialog("Enter the ages, program will stop at length limit.")));
    }
    /*Collections.sort(Ages);
    for (int counter : Ages) {
        JOptionPane.showMessageDialog(null,
                "The ages in ascending order:\n" + counter);
    }
    n++;*/
    AverageAge(Ages);
}

// *Sets back the value of n to original input.
public static int AverageAge(List<Integer> Ages) {
    int sum = 0;
    for (int x = 0; x < Ages.size(); x++) {
        sum = sum + Ages.get(x);
    }
    int Avg = sum / Ages.size();
    JOptionPane.showMessageDialog(null, "The average age is: \n" + Avg);
    return Avg;

 }
}