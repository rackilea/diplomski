import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Point;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.Set;
import java.util.LinkedHashMap;
class GridBagFrame extends JFrame implements ActionListener
{
    GridBagLayout gb ;
    GridBagConstraints gc;
    Map <Point,JButton> map ;
    final int SIZE = 20;
    public void createAndShowGUI()
    {
        gb = new GridBagLayout();
        gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.BOTH;
        map = new LinkedHashMap<Point,JButton>();
        Container container = getContentPane();
        container.setLayout(gb);
        int x =0 , y = -1 ;
        JButton[] button = new JButton[SIZE];
        for (int i = 0 ; i < SIZE ; i++ )
        {
            button[i] = new JButton(String.valueOf(i + 1));
            if (i % 4 == 0)
            {
                x = 0 ;
                y = y +1;
            }
            gc.gridx = x++;
            gc.gridy = y;
            gb.setConstraints(button[i],gc);
            container.add(button[i]);
            map.put(new Point(x,y),button[i]);
            button[i].setActionCommand(x+","+y);
            button[i].addActionListener(this);
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent evt)
    {
        resetAll();
        JButton source = (JButton)evt.getSource();
        String command = source.getActionCommand();
        String[] arr = command.split(",");
        int x = Integer.parseInt(arr[0]);
        int y = Integer.parseInt(arr[1]);
        for ( int iy = y - 1; iy <= y + 1; iy++)
        {
            for (int ix = x -1 ; ix <= x + 1 ; ix++)
            {
                JButton button = map.get(new Point(ix,iy));
                if (button != null)
                {
                    button.setForeground(Color.red);
                }
            }
        }
        source.setForeground(Color.blue);
    }
    private void resetAll()
    {
        Set<Point> pointSet = map.keySet();
        for (Point point : pointSet )
        {
            map.get(point).setForeground(Color.black);
        }
    }
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater( new Runnable()
        {
            @Override
            public void run()
            {
                GridBagFrame frame = new GridBagFrame();
                frame.createAndShowGUI();
            }
        });
    }
}