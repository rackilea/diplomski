do {
    grade = Integer.parseInt(JOptionPane.showInputDialog("Enter a grade:"));
    if (grade == SENTINEL) {
        break;                  // exit the loop upon hitting the SENTINEL value
    }

    sum = sum + grade;          // only increase the sum for positive values
    count = count + 1;
} while (true);

avg = sum/count;
JOptionPane.showMessageDialog(null,String.format("%.1f",avg));