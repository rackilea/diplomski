import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainProgram {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of calculations you would like to do");

        long no = Long.parseLong(reader.readLine());
        long step = 0;
        double ans = 3;
        long j = 2;

        double pi = 0.0;

        while (true) {
            step++;
            if ((step % 2) == 1) {
                ans += 4.0 / (1.0 * j * (j + 1) * (j + 2));
            } else {
                ans -= 4.0 / (1.0 * j * (j + 1) * (j + 2));
            }

            j += 2;
            pi = ans;

            if (step >= no)
                break;
        }

        System.out.println("You calculated that pi is");
        System.out.println(pi);
        System.out.println("Pi is actually");
        System.out.println(3.1415926535897932);

        double error = pi / 3.1415926535897932;
        if (error >= 1) {
            double bigerror = 2 - error;
            System.out.print("Your accuracy is: ");
            System.out.print(bigerror * 100);
            System.out.println(" percent");
            System.out.println(step);
        } else {
            System.out.print("Your accuracy is: ");
            System.out.print(error * 100);
            System.out.println(" percent.");
            System.out.println(step);
        }
    }
}