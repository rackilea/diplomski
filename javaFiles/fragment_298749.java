import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OverlappingRectangles {

    public static void main(String[] args) {
        String f = args[0];
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            while (br.ready()) {
                String cs[] = br.readLine().split(",");
                int[] ci = new int[cs.length];
                int i = 0;
                for (String s : cs) {
                    ci[i] = Integer.parseInt(s);
                    i += 1;
                }

                if (ck(ci[0], ci[1], ci[2], ci[3], ci[4], ci[5], ci[6], ci[7])) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    public static boolean ck(int rx, int ry, int rw, int rh, int tx, int ty, int tw, int th) {
        //ATTENTION!
        //rx,ry -> upper-left corner of rect A
        //rw,rh -> bottom-right corner of rect A
        //tx,ty -> upper-left corner of rect B
        //tw,th -> bottom-right corner of rect B
        return ((rw < rx || rw >= tx)
                && (rh < ry || rh >= ty)
                && (tw < tx || tw >= rx)
                && (th < ty || th >= ry));
    }
}