import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class Contact {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            public void run() {
                JPanel gui = new JPanel(new BorderLayout(5,5));
                gui.setBorder( new EmptyBorder(3,3,3,3) );

                JPanel controls = new JPanel( new BorderLayout(5,5) );

                JPanel buttons = new JPanel(new GridLayout(0,1,4,4));
                buttons.add( new JButton("Show") );
                buttons.add( new JButton("Add") );
                buttons.add( new JButton("Update Number") );
                buttons.add( new JButton("Delete") );
                buttons.setBorder( new TitledBorder("Contact") );

                controls.add( buttons, BorderLayout.NORTH );

                controls.add(new JScrollPane(new JTree()), BorderLayout.CENTER);

                gui.add(controls, BorderLayout.WEST);

                gui.add(new JTextArea("CardLayout for CRUD components.",10,30));

                gui.add(new JLabel("Output label.."), BorderLayout.SOUTH);

                JToolBar toolbar = new JToolBar();
                toolbar.add(new JCheckBox("Auto save", true));
                toolbar.add(new JCheckBox("Always On Top"));
                gui.add(toolbar, BorderLayout.NORTH);

                JOptionPane.showMessageDialog(null, gui);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}