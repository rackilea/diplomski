import com.sun.deploy.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {

    static List<String> odds = new ArrayList<>();

    public static void main(String[] args) {
        int n = 0;
        String str = JOptionPane.showInputDialog(null, "make the limits = ");
        n = Integer.parseInt(str);
        printOdds(n);
        String result = StringUtils.join(odds, ", ");
        JOptionPane.showMessageDialog(null, result);
    }

    static void printOdds(int n) {
        if (n < 1) return;
        if (n%2 == 0) n--;
        printOdds(n-2);
        odds.add(String.valueOf(n));
    }
}