import java.io.*;
import java.util.*;

public class Problem2 {
    public static void main(String[] args) throws IOException {
        File marge = new File("marge.txt");
        Scanner fileScan = new Scanner(marge);
        String original;
        while (fileScan.hasNext()) {
            original = fileScan.nextLine();
            System.out.println(original);
        }
        fileScan = new Scanner(marge);
        String lefttoright;
        while (fileScan.hasNext()) {
            lefttoright = fileScan.nextLine();
            StringBuffer sb = new StringBuffer(lefttoright);
            System.out.println(sb.reverse());
        }
        fileScan = new Scanner(marge);
        String upsidedown;
        Stack<String> list = new Stack<String>();
        while (fileScan.hasNext()) {
            upsidedown = fileScan.nextLine();
            list.push(upsidedown);
        }
        for (int i = 0; i <= list.size(); i++) {
            System.out.println(list.pop());
        }

        fileScan.close();
    }
}