import javax.swing.JOptionPane;

public class Main {
    // make Numbers global
    public static double Numbers[];

    public static void main(String[] args) {

        double SelectNumber = 0;
        int a = 0;

        do {
            try {
                String UserInput = JOptionPane
                        .showInputDialog("Enter the amount of numbers you would like to average");
                SelectNumber = Integer.parseInt(UserInput);
            } catch (NumberFormatException e) {
                JOptionPane
                        .showMessageDialog(null, "Value must be an integer!");
            }
        } while (SelectNumber < 1);

        Numbers = new double[(int) SelectNumber];

        for (a = 0; a < Numbers.length; a++) {
            String EnterNumber = JOptionPane
                    .showInputDialog("Please enter a number.");
            Numbers[a] = Double.parseDouble(EnterNumber);

        }

        // just checking
        showAvg("");

    }

    // Create method in order to calculate calcavgnow

    // changed to void as function is void function
    public static void showAvg(String n) {
        JOptionPane.showMessageDialog(null, getTotal(Numbers) + " divided by "
                + Numbers.length + " is " + getAvg(Numbers));
    }

    public static double getAvg(double numbers[]) {
        return getTotal(numbers) / numbers.length;
    }

    public static double getTotal(double numbers[]) {
        double total = 0;
        for (double i : numbers)
            total += i;
        return total;
    }

}