public class Main {
    public static void main(String[] args) {

         int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Rows"));
         int m = Integer.parseInt(JOptionPane.showInputDialog(null, "Columns"));

        int[][] a = new int[n][m];
        int[] b = new int[n];
        int[] c = new int[m];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {

                a[i][j] = Integer.parseInt( JOptionPane.showInputDialog(null, "Type" + "an int. A[" + i + "]" + "[" + j + "] = "));

                b[i] += a[i][j];
                c[j] += a[i][j];
            }

        }

        // USED FOR PRINTING
        //  -------------------------
        for (int i = 0; i < b.length; i++) {
            System.out.println("Sum Row " + (i + 1) + " is " + b[i]);
        }

        for (int i = 0; i < c.length; i++) {
            System.out.println("Sum Column " + (i + 1) + " is " + c[i]);
        }
        // -------------------------
    }
}