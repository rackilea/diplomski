import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ActionExample {

    private boolean testCondition = false;
    private JMenuItem DeleteTask = new JMenuItem("Delete Task");

    public ActionExample() {
        Action sample = new SampleAction();
        DeleteTask.setMnemonic(KeyEvent.VK_D);
        DeleteTask.setToolTipText("Delete a Task");
        DeleteTask.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                if (testCondition) {
                    testCondition = false;
                    DeleteTask.setToolTipText("Changed Tool Tip");
                } else {
                    testCondition = true;
                    DeleteTask.setToolTipText("Delete a Task");
                }
            }
        });
        JMenu menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_M);
        menu.add(sample);
        menu.add(DeleteTask);
        menu.addMenuListener(new SampleMenuListener());
        JToolBar tb = new JToolBar();
        tb.add(sample);
        JTextField field = new JTextField(10);
        field.setAction(sample);
        JFrame f = new JFrame("ActionExample");
        JMenuBar mb = new JMenuBar();
        mb.add(menu);
        f.setJMenuBar(mb);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(tb, BorderLayout.NORTH);
        f.getContentPane().add(field, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ActionExample actionExample = new ActionExample();
            }
        });
    }
}

class SampleMenuListener implements MenuListener {

    @Override
    public void menuSelected(MenuEvent e) {
        System.out.println("menuSelected");
    }

    @Override
    public void menuDeselected(MenuEvent e) {
        System.out.println("menuDeselected");
    }

    @Override
    public void menuCanceled(MenuEvent e) {
        System.out.println("menuCanceled");
    }
}

class SampleAction extends AbstractAction {

    private static final long serialVersionUID = 1L;

    public SampleAction() {
        super("Sample");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt S"));
        putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_S));
        putValue(SHORT_DESCRIPTION, "Just a sample action");
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("sample...");
    }
}