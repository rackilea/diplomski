import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

public class ComboBoxTitleTest
{
    public static final void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                new ComboBoxTitleTest().createAndShowGUI();
            }
        });
    }

    public void createAndShowGUI()
    {
        JFrame frame = new JFrame();

        JPanel mainPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();
        frame.add(mainPanel);
        frame.add(buttonsPanel, BorderLayout.SOUTH);

        String[] options = { "Spain", "Germany", "Ireland", "The kingdom of far far away" };

        final JComboBox comboBox = new JComboBox(options);
        comboBox.setRenderer(new MyComboBoxRenderer("COUNTRY"));
        comboBox.setSelectedIndex(-1); //By default it selects first item, we don't want any selection
        mainPanel.add(comboBox);

        JButton clearSelectionButton = new JButton("Clear selection");
        clearSelectionButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                comboBox.setSelectedIndex(-1);
            }
        });
        buttonsPanel.add(clearSelectionButton);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class MyComboBoxRenderer extends JLabel implements ListCellRenderer
    {
        private String _title;

        public MyComboBoxRenderer(String title)
        {
            _title = title;
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean hasFocus)
        {
            if (index == -1 && value == null) setText(_title);
            else setText(value.toString());
            return this;
        }
    }
}