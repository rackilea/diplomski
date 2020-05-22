import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 *
 * @author matthewtingle
 */
public class AnimatedSelectionSortPanel extends javax.swing.JPanel {
    private static final int NUMBER_INDEXES = 50;
    private static int[] number = new int[NUMBER_INDEXES];

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.getContentPane().setLayout(new GridLayout(1,1));
                f.getContentPane().add(new AnimatedSelectionSortPanel());
                f.setSize(600,300);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }

    /**
     * Creates new form AnimatedSelectionSortPanel
     */
    public AnimatedSelectionSortPanel() {

        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                selectionSort();
                repaint();
            }
        });

        loadArray();
        for(int i = 0; i < NUMBER_INDEXES; i++){
            if(i%10==0){
                System.out.println("");
                System.out.print("" + number[i]+", ");
            }else{
                System.out.print("" + number[i]+", ");
            }
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawPass(g);
        for (int i = 0; i < NUMBER_INDEXES; i++){
            if(i%10==0){
                System.out.println("");
                System.out.print(""+ number[i]+ ", ");
            }else{
                System.out.print(""+ number[i]+ ", ");
            }
        }
    }

    private void loadArray() {
        Random rnd = new Random();
        for (int i = 0; i < NUMBER_INDEXES; i++) {
            number[i] = rnd.nextInt((100 - 20) + 1) + 20;
        }
    }

    public void drawPass(Graphics g) {
        int xBasePosition = 10;
        int yBasePosition = 100;
        for (int i = 0; i < NUMBER_INDEXES; i++) {
            g.drawLine(xBasePosition,yBasePosition+20, xBasePosition, yBasePosition - number[i]);
            xBasePosition+=10;
        }
    }
    public void selectionSort(){
        for(int top = 0; top <= number.length - 2; top++){
            int minIndex = top;
            for (int i = top + 1; i <= number.length - 1; i++) {
                if (number[i] < number[minIndex]) {
                    minIndex = i;
                }
            }swapElements(top,minIndex);
        }
    }
    private void swapElements(int index1, int index2){
        int tmp = number[index1];
        number[index1] = number[index2];
        number[index2] = tmp;
    }
}