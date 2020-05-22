import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddRuleFrame extends JFrame implements ActionListener {
    private JPanel panel;
    private JPanel buttonPanel;
    private JScrollPane scroll;
    private JButton btnAddType;
    private JButton btnDeleteField;
    private JButton btnSaveRule;

    public AddRuleFrame() {
        getContentPane().setLayout(new BorderLayout());       
        buttonPanel = new JPanel();
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        btnAddType = new JButton("Add type");
        btnAddType.addActionListener(this);
        buttonPanel.add(btnAddType);

        btnDeleteField = new JButton("Delete field");
        btnDeleteField.addActionListener(this);
        buttonPanel.add(btnDeleteField);

        btnSaveRule = new JButton("Save rule");
        buttonPanel.add(btnSaveRule);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        scroll = new JScrollPane(panel,
                                 JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        getContentPane().add(scroll, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // this centers the window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnAddType) {
            panel.add(new BoxyTextField(20));
            panel.revalidate();
        }
        validate();
    }

    class BoxyTextField extends JTextField {
        BoxyTextField(int width) {
            super(width);
        }

        @Override
        public Dimension getMaximumSize() {
            Dimension size = super.getMaximumSize();
            size.height = getPreferredSize().height;
            return size;
        }
    }

    @Override
    public Dimension getPreferredSize() {
        // See my exchange with MadProgrammer in the comments for
        // a discussion of whether Toolkit#getScreenSize() is an
        // appropriate way to get the screen dimensions for sizing
        // a window.
//        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        // This is the correct way, as suggested in the documentation
        // for java.awt.GraphicsEnvironment#getMaximumWindowBounds():
        GraphicsConfiguration config = getGraphicsConfiguration();
        Insets  insets = Toolkit.getDefaultToolkit().getScreenInsets(config);
        Dimension size = config.getBounds().getSize();
        size.width  -= insets.left + insets.right;
        size.height -= insets.top  + insets.bottom;
        // Now we have the actual available space of the screen
        // so we can compute a relative size for the JFrame.
        size.width   = size.width / 3;
        size.height  = size.height * 2 / 3;
        return size;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AddRuleFrame frame = new AddRuleFrame();
            }
        });
    }
}