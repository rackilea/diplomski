import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Green {

    public static int[] values = new int[100];
    public final int COLOR_RANGE = 150;
    public static int count;

    JFrame window = new JFrame("Green Values");
    JPanel main_panel = new JPanel();
    JPanel green_panel;

    public Green() {

        window.setSize(600, 600);
        window.add(main_panel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);

    }

    public void add(JComponent comp) {
        main_panel.add(comp);
        main_panel.revalidate();
        main_panel.repaint();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                Green g = new Green();

                try {
                    Scanner sc = new Scanner(new File("green.txt"));

                    int i = 0;
                    while (sc.hasNextInt()) {
                        values[i++] = sc.nextInt();
                        count++;
                        JPanel green_panel = new JPanel();     // help
                        g.add(green_panel);           // help - is this correct?

                        sc.close();

                        int max = values[0];
                        int min = values[0];
                        for (i = 0; i < count; i++) {
                            if (max < values[i]) {
                                max = values[i];
                            }
                            if (min > values[i]) {
                                min = values[i];
                            }
                        }

                        int temp;
                        int val = 0;

                        for (i = 0; i < count; i++) {
                            values[i] = val;
                            System.out.println("Array value: " + val + " | " + "Green value: " + g.greenValue(val, max, min));
                            temp = values[i + 1];
                            val = temp;
                        }
                    }
                } catch (FileNotFoundException exp) {
                    exp.printStackTrace();
                }
            }
        });

    }

    public int greenValue(int val, int max, int min) {

        int colorValue;
        int arrayRange = (max - min);
        colorValue = (((val - min) * COLOR_RANGE) / arrayRange) + 100;

        return colorValue;
    }

}