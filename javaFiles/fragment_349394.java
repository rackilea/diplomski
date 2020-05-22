package Rezi30035097;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


class Program01 {

    protected static BufferedReader br;
    protected static PrintWriter x;

    public static void main(String[] param) throws IOException {
        intro();
        System.exit(0);
    }

    protected static boolean matchString(String s) throws FileNotFoundException, IOException {
        br = new BufferedReader(new FileReader(new File("data.txt")));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains(s)) {

                br.close();
                br = null;
                return true;
            }
        }
        return false;
    }

    public static void intro() throws IOException {
        x = new PrintWriter(new FileWriter("data.txt"));

        while (true) {
            Object[] possibleValues = {"Transfer", "Receive", "Cancel"};
            Object selectedValue = JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);

            String name;
            String surname;
            String amount;
            String info;

            if (selectedValue.equals(possibleValues[0])) {
                name = JOptionPane.showInputDialog(null, "recipients name");
                surname = JOptionPane.showInputDialog(null, "recipients surname");
                amount = JOptionPane.showInputDialog(null, "amount");
                info = name + surname + amount;

                x.write(info);
                x.flush();

            } else if (selectedValue.equals(possibleValues[1])) {
                String inputname;
                String inputsurname;
                String inputamount;
                inputname = JOptionPane.showInputDialog(null, "your name");
                inputsurname = JOptionPane.showInputDialog(null, "your surname");
                inputamount = JOptionPane.showInputDialog(null, "amount");
                String inputinfo = inputname + inputsurname + inputamount;

                if (matchString(inputinfo)) {
                    JOptionPane.showMessageDialog(null, "You will receive " + inputamount + "$");
                } else {
                    JOptionPane.showMessageDialog(null, "Request not found");
                }
                inputinfo = null;

            } else if (selectedValue.equals(possibleValues[2])) {
                x.close();
                System.exit(0);
            }
        }

    }
}