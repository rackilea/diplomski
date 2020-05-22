//Copyright © 2000–2016, Robert Sedgewick and Kevin Wayne. 
public class ThueMorse { 
   public static void main(String[] args) { 
        int n = Integer.parseInt(args[0]);
        String thue   = "0";
        String morse  = "1";

        for (int i = 1; i <= n; i++) {
            String t = thue;             // save away values
            String m = morse;
            thue  += m;
            morse += t;
        }
        System.out.println(thue);
    }
}