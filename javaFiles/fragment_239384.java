import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class MainWindow extends JFrame {

    private class ShowFormulaWindowAction extends AbstractAction {
        public ShowFormulaWindowAction() {
            super("Show formulas...");
        }

        public void actionPerformed(ActionEvent actionEvent) {
            FormulaWindow formulaWindow = new FormulaWindow(MainWindow.this);
            formulaWindow.setVisible(true);
        }
    }

    public MainWindow() {
        super("Main window");
        JMenu fileMenu = new JMenu("Extras");
        fileMenu.add(new JMenuItem(new ShowFormulaWindowAction()));
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(final String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow mainWindow = new MainWindow();
                mainWindow.setSize(350, 250);
                mainWindow.setVisible(true);
            }
        });
    }
}