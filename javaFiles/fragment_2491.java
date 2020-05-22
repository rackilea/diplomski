import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.tree.TreePath;

public class Main extends JFrame {

    private static final long serialVersionUID = 4648172894076113183L;

    public Main() {
        super();
        setSize(500, 500);
        this.getContentPane().setLayout(new BorderLayout());
        final JCheckBoxTree cbt = new JCheckBoxTree();
        final JButton button = new JButton("get checked");
        JPanel panel = new JPanel();
        panel.add(cbt);
        panel.add(button);
        this.getContentPane().add(panel);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                printChecked(cbt);
            }
        });

        cbt.addCheckChangeEventListener(new JCheckBoxTree.CheckChangeEventListener() {
            public void checkStateChanged(JCheckBoxTree.CheckChangeEvent event) {
                printChecked(cbt);
            }
        });         
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void printChecked(final JCheckBoxTree cbt) {
        System.out.println("Select items");
        TreePath[] paths = cbt.getCheckedPaths();
        for (TreePath tp : paths) {
            for (Object pathPart : tp.getPath()) {
                System.out.print(pathPart + ",");
            }                   
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Main m = new Main();
        m.setVisible(true);
    }
}