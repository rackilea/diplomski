import javax.swing.JOptionPane;
public class vinalcialApplication {
public static void main(String args[]){
    String monthlySaving = JOptionPane.showInputDialog("Enter the monthly savings");
    double monthsaving = Double.parseDouble(monthlySaving);
    //define monthly rate
    double monthlyrate = 1.00417;
    double totalrate = monthlyrate + 0.00417;
    double value = monthsaving * (totalrate);
    for(int i = 1; i<6;i++) {
        value = (value + 100)*(monthlyrate);
    }
    System.out.print("After the sixth month, the account value is " value);
}