import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GraphicalQuickSort
{
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(new BorderLayout());

        final MyArrayClass myArrayClass = new MyArrayClass(25);
        myArrayClass.NumberGenerator();
        GraphicalQuickSortPanel panel = 
            new GraphicalQuickSortPanel(myArrayClass);
        myArrayClass.graphicalQuickSortPanel = panel;

        JButton sortButton = new JButton("Sort");
        sortButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                performSorting(myArrayClass);
            }
        });
        f.getContentPane().add(sortButton, BorderLayout.NORTH);

        f.getContentPane().add(panel, BorderLayout.CENTER);
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static void performSorting(final MyArrayClass myArrayClass)
    {
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                myArrayClass.QuickSort(0, myArrayClass.ArraySize-1);
                System.out.println("Done");
            }
        });
        thread.start();
    }
}

class GraphicalQuickSortPanel extends JPanel 
{
    private final MyArrayClass myArrayClass;

    public GraphicalQuickSortPanel(MyArrayClass myArrayClass) 
    {
          this.myArrayClass = myArrayClass;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        int size = myArrayClass.ArraySize;
        int barWidth = getWidth() / size; 

        for (int i = 0; i < size; i++) 
        {
            int value = myArrayClass.MyArray[i];
            int x = i * barWidth;
            int y = getHeight()-value;
            g.fillRect(x+1, y, barWidth-2, value);
        }        
    }
}


class MyArrayClass {

    int MyArray[];
    int ArraySize;    
    int res;

    // This should NOT be a direct reference, but
    // a generic listener instead!
    GraphicalQuickSortPanel graphicalQuickSortPanel;
    long delayAfterSwapMS = 500;

    public MyArrayClass(int size) {
        ArraySize = size;
        MyArray = new int[ArraySize];
    }

    public void NumberGenerator() {        
        for (int i = 0; i < ArraySize; i++) {
            MyArray[i] = (int) (Math.random() * 99) + 1;            
        }
    }  

    public void QuickSort(int Left, int Right) {
        if (Right - Left <= 0) {
            return;
        }  else {
            int Pivot = MyArray[Right];            
            Partitioning(Left, Right, Pivot);
            int PivotValue = res;
            QuickSort(Left, PivotValue - 1);
            QuickSort(PivotValue + 1, Right);
        }
    }

    public void Partitioning(int Left, int Right, int Pivot) {
        int LeftP = Left - 1;
        int RightP = Right;
        while (true) {
            while (LeftP < Right && MyArray[++LeftP] < Pivot) {                
            }
            while (RightP > 0 && MyArray[--RightP] > Pivot) {                
            }
            if (RightP <= LeftP) {
                SwapValues(LeftP, Right);
                res = LeftP;
                break;
            } else {
                SwapValues(LeftP, RightP);
                break;
            }
        }  
    }  

    private void SwapValues(int LeftP, int RightP) {
        int aux = MyArray[LeftP];
        MyArray[LeftP] = MyArray[RightP];
        MyArray[RightP] = aux;

        // This should be solved differently
        try
        {
            Thread.sleep(delayAfterSwapMS);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        graphicalQuickSortPanel.repaint();
    }
}