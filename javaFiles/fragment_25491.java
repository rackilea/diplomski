public class Booking2 {

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);

        jf.setLayout(null); // this is important 

        jf.setSize(700, 400);

        int c1 = 40;
        int count = 0, count2 = 0, count3 = 0, count4 = 0, x;
        JLabel[] jl = new JLabel[c1];

        for (int i = 0; i <= c1 - 1; i++) {
            jl[i] = new JLabel();

            if (i <= 9) {
                x = 25 * count;
                jl[i].setBounds(x, 50, 20, 20);
                count++;
            }
            if (i >= 10 && i <= 19) {
                x = 25 * count2;
                jl[i].setBounds(x, 80, 20, 20);
                count2++;
            }
            if (i >= 20 && i <= 29) {
                x = 25 * count3;
                jl[i].setBounds(x, 110, 20, 20);
                count3++;
            }
            if (i >= 30 && i <= 39) {
                x = 25 * count4;
                jl[i].setBounds(x, 130, 20, 20);
                count4++;
            }
            //jl[i].setIcon(new ImageIcon(Booking2.class.getResource("booked.png")));
            jl[i].setText("O");
            jf.add(jl[i]);
        }
         jf.revalidate();
        jf.setVisible(true);
    }

}