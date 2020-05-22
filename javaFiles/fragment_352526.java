import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class SharedListSelectionModel
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

        DefaultListModel modelA = new DefaultListModel();
        JList listA = new JList(modelA);
        DefaultListModel modelB = new DefaultListModel();
        JList listB = new JList(modelB);
        for (int i=0; i<10; i++)
        {
            modelA.addElement("A"+i);
            modelB.addElement("B"+i);
        }

        ListSelectionModel selectionModel = new DefaultListSelectionModel();
        listA.setSelectionModel(selectionModel);
        listB.setSelectionModel(selectionModel);

        JPanel p = new JPanel(new GridLayout(1,2));
        p.add(new JScrollPane(listA));
        p.add(new JScrollPane(listB));
        f.getContentPane().add(p, BorderLayout.CENTER);

        f.setSize(300,300);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}