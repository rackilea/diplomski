import javax.swing.JOptionPane;

public class CSwing {
    public static void main(String[] args) {
        String usd;
        double dUSD, pounds, rouble, euros;

        System.out.println("t\tCURRENCY CONVERTER");

        usd  = JOptionPane.showInputDialog(null,
                "Please enter the Dollar amount in USD");
        dUSD = Double.parseDouble(usd);

        rouble = (dUSD * 34.89);
        pounds = (dUSD * 0.61);
        euros  = (dUSD * 0.73);

        JOptionPane.showMessageDialog(null, "Your Given Amount: $" + (dUSD)
                + "\n\nYour Rouble Conversion is:$ " + (rouble)
                + "\n\nYour Pound Conversion is:$ "  + (pounds)
                + "\n\nYour Euro Conversion is:$ "   + (euros));
        System.exit(0);
    }
}