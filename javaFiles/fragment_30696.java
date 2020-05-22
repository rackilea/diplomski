import java.io.*;

public class Frequency {

    public static void main(String args[]) {
        double r, l, c, f;  //r=resistance,l=induction,c=capacitance,f=frequency

        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter the RESISTANCE:");
            r = Double.parseDouble(buff.readLine());

            System.out.print("Enter the INDUCTION:");
            l = Double.parseDouble(buff.readLine());

            System.out.print("Enter the CAPACITANCE:");
            c = Double.parseDouble(buff.readLine());

            f = Math.sqrt((1 / l * c) - Math.pow(r, 2) / (4 * Math.pow(c, 2)));
            System.out.println("The FREQUENCY is:" + f);
        }

        catch (Exception e) {
            System.out.println(e);
        }
    }
}