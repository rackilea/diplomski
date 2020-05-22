import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class TableContentsTest
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

        String[] columnNames = {"Date","Field", "Home Team","Visitor Team", "Score"};
        String[][] contents = createTableContents();
        JTable table = new JTable(contents, columnNames);

        f.getContentPane().add(table);
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }
    public static String[][] createTableContents()
    {
        String input = 
            "Sun 02-16-14 09:45 PM,1,REAL TIRED,JUST WACK AT IT,2 - 4,"+"\n"+
            "Sun 02-23-14 08:10 PM,1,BALLERS,REAL TIRED,4 - 11,"+"\n"+
            "Sun 03-02-14 09:00 PM,1,REAL TIRED,EL TRI,1 - 7,"+"\n"+
            "Sun 03-09-14 05:50 PM,1,GO GO POWER RANGERS,REAL TIRED,4 - 9,"+"\n"+
            "Sun 03-16-14 06:40 PM,1,REAL TIRED,GAME OF GROANS,"+"\n"+
            "Sun 03-23-14 09:00 PM,1,HUNGOVER HAT TRICKS,REAL TIRED,"+"\n"+
            "Sun 03-30-14 07:25 PM,1,REAL TIRED,PRESTIGE WORLD WIDE,"+"\n"+
            "Sun 04-06-14 04:20 PM,1,REAL TIRED,BALLERS,"+"\n";

        String[] lines = input.split("\n");
        String result[][] = new String[lines.length][];
        for (int i=0; i<lines.length; i++)
        {
            result[i] = Arrays.copyOf(lines[i].split(","), 5);
        }
        return result;
    }
}