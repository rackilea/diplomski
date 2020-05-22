import javax.swing.JOptionPane;
public class example {

public static void main(String[] args) {
    String results = "";
    int numbers[] = new int[10];
    int j = 0;
    int i;
    for(i = 0; i < numbers.length; i++)
    {
        numbers[i] = (int) ((Math.random() * 31) + 20);
        results += numbers[i] + "\n";
    }
    boolean duplicateFound = false;
    for(i = 0; i < numbers.length - 1 && !duplicateFound; i++)
    {
        for(j = i + 1; j < numbers.length && !duplicateFound; j++)
        {
            if(numbers[i] == numbers[j])
                duplicateFound = true;
        }
    }
    if(duplicateFound)
            results += "First pair of duplicates were found at positions: " + (i) + " and " + (j);
    else
            results += "No duplicates were generated.";
    JOptionPane.showMessageDialog(null, results);

}

}