import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogTest implements Runnable {

    private JDialog dialog;
    private JList jlist;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new DialogTest());
    }

    @Override
    public void run() {
        ActionListener okListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                close(true);
            }
        };

        ActionListener cancelListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                close(false);
            }
        };

        ActionListener otherListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                doOther();
            }
        };
        JButton okButton = new JButton("OK");
        okButton.addActionListener(okListener);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(cancelListener);
        jlist = new JList(new String[]{"A", "B", "C", "D", "E", "F", "G"});
        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlist.setVisibleRowCount(5);
        JScrollPane scroll = new JScrollPane(jlist);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(okButton);
        buttonsPanel.add(cancelButton);
        JPanel content = new JPanel(new BorderLayout());
        content.add(scroll, BorderLayout.CENTER);
        content.add(buttonsPanel, BorderLayout.SOUTH);
        dialog = new JDialog((Frame) null, true);
        dialog.setContentPane(content);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.getRootPane().registerKeyboardAction(okListener,
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        dialog.getRootPane().registerKeyboardAction(cancelListener,
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        // This doesn't work
        /*dialog.getRootPane().registerKeyboardAction(otherListener,
        KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0),
        JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);*/
        dialog.getRootPane().getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "doSomething");
        dialog.getRootPane().getActionMap().put("doSomething", new AbstractAction() {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
    }

    private void close(boolean commit) {
        if (commit) {
            System.out.println("Now saving...");
        } else {
            System.out.println("Now closing...");
            System.exit(0);
        }
    }

    private void doOther() {
        System.out.println("current selection: " + jlist.getSelectedValue());
    }
}