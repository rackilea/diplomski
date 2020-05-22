import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListSelectionDoubleEvent
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui()
    {
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        listModel.addElement("Male");
        listModel.addElement("Female");
        listModel.addElement("Others");

        JList<String> list = new JList<String>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setBorder(
            BorderFactory.createTitledBorder("How do you identify yourself?"));
        list.setBackground(SystemColor.info);

        list.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent event)
            {
                if (event.getValueIsAdjusting())
                {
                    //System.out.println("Adjusting. Ignore this");
                    return;
                }
                String gender = list.getSelectedValue();
                System.out.print(gender);
            }
        });

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(list);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}