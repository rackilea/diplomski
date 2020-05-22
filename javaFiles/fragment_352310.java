import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MyWindow extends JFrame 
{

    public MyWindow() 
    {
        super("FNA");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ComponentsPanel pane = new ComponentsPanel();
        add(pane);
        setVisible(true);
    }

    public static void main(String[] args) 
    {
        EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                try 
                {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } 
                catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) 
                {
                    ex.printStackTrace();
                }

                new MyWindow();
            }
        });
    }

    public class ComponentsPanel extends JPanel 
    {
        private final JLabel pLabel;
        private final String pNum;
        private final String newbDate;
        private final String biLimit;
        private final String lapses;

        // variable declarations
        // constructor
        public ComponentsPanel() 
        {
            GridBagConstraints gbc = new GridBagConstraints();

            pLabel = new javax.swing.JLabel("Policy #");
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(pLabel, gbc);

            JTextField pTextField = new javax.swing.JTextField();
            pTextField.setSize(10, 10);
            gbc.gridx = 1;
            gbc.gridy = 0;
            add(pTextField, gbc);
            this.pNum = pTextField.getText();

            JLabel newbLabel = new javax.swing.JLabel("NB Date");
            gbc.gridx = 0;
            gbc.gridy = 1;
            add(newbLabel, gbc);

            JTextField newbTextField = new javax.swing.JTextField();
            gbc.gridx = 1;
            gbc.gridy = 1;
            add(newbTextField, gbc);

            JButton newbButton = new javax.swing.JButton("NEW DATE");
            gbc.gridx = 2;
            gbc.gridy = 1;
            add(newbButton, gbc);
            this.newbDate = newbTextField.getText();

            JLabel biLabel = new javax.swing.JLabel("BI Limits");
            gbc.gridx = 0;
            gbc.gridy = 2;
            add(biLabel, gbc);

            JTextField biTextField = new javax.swing.JTextField();
            gbc.gridx = 1;
            gbc.gridy = 2;
            add(biTextField, gbc);

            JComboBox<Object> bilimButton = new javax.swing.JComboBox<>();
            bilimButton.setToolTipText("Choose Verified BILimits");
            gbc.gridx = 2;
            gbc.gridy = 2;
            add(bilimButton, gbc);

            JComboBox<Object> bicslButton = new javax.swing.JComboBox<>();
            gbc.gridx = 3;
            gbc.gridy = 2;
            add(bicslButton, gbc);
            this.biLimit = biTextField.getText();

            JLabel lapseLabel = new javax.swing.JLabel("Lapse #");
            gbc.gridx = 0;
            gbc.gridy = 3;
            add(lapseLabel, gbc);

            JTextField lapseTextField = new javax.swing.JTextField();
            gbc.gridx = 1;
            gbc.gridy = 3;
            add(lapseTextField, gbc);

            JComboBox<Object> lapseButton = new javax.swing.JComboBox<>();

//          for (int i = 0; i < lapse.length; i++) 
//          {
//              lapse[i] = Integer.toString(i);

//              if (i < 10) 
//              {
//                  lapse[i] = "0" + Integer.toString(i);
//              }
//          }

//          lapseButton.setModel(new DefaultComboBoxModel(lapse));
            gbc.gridx = 2;
            gbc.gridy = 3;
            add(lapseButton, gbc);
            this.lapses = lapseTextField.getText();

            JButton noChangeButton = new javax.swing.JButton("NO CHANGE");
            gbc.gridx = 0;
            gbc.gridy = 4;
            add(noChangeButton, gbc);

            JButton changeButton = new javax.swing.JButton("CHANGE");
            gbc.gridx = 1;
            gbc.gridy = 4;
            add(changeButton, gbc);

            JButton decButton = new javax.swing.JButton("DECREASE");
            gbc.gridx = 2;
            gbc.gridy = 4;
            add(decButton, gbc);

            JButton incButton = new javax.swing.JButton("INCREASE");
            gbc.gridx = 3;
            gbc.gridy = 4;
            add(incButton, gbc);

            JButton cpyButton = new javax.swing.JButton("COPY");
            cpyButton.setToolTipText("copy comment");
            gbc.gridx = 0;
            gbc.gridy = 5;
            add(cpyButton, gbc);

            JButton clrButton = new javax.swing.JButton("CLEAR");
            clrButton.setToolTipText("clear all fields");
            gbc.gridx = 3;
            gbc.gridy = 5;
            add(clrButton, gbc);

            JTextArea dispTextArea = new javax.swing.JTextArea(10, 10);
            dispTextArea.setEditable(true);
            dispTextArea.setLineWrap(true);
            dispTextArea.setColumns(20);
            dispTextArea.setRows(5);
            add(dispTextArea);
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.weightx = 0.5;
            gbc.gridwidth = 4;
            gbc.anchor = GridBagConstraints.PAGE_END;
            add(dispTextArea, gbc);

            // adding listeners to components
            // registering all components with their respective listeners
            CompHandler compHandler = new CompHandler();

            pTextField.addActionListener(compHandler);
            biTextField.addActionListener(compHandler);
            newbTextField.addActionListener(compHandler);
            bilimButton.addActionListener(compHandler);
            bicslButton.addActionListener(compHandler);
            noChangeButton.addActionListener(compHandler);
            changeButton.addActionListener(compHandler);
            decButton.addActionListener(compHandler);
            incButton.addActionListener(compHandler);
            decButton.addActionListener(compHandler);
            cpyButton.addActionListener(compHandler);
            clrButton.addActionListener(compHandler);
        }

        // class to handle text fields
        private class CompHandler implements ActionListener 
        {
            @Override
            public void actionPerformed(ActionEvent e) {}
        } // end component handler class
    }
}