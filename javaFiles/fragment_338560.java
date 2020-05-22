import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.KeyStroke;

public class ClipboardTable {

    private static final Clipboard clipboard = Toolkit.getDefaultToolkit()
            .getSystemClipboard();
    public static JTable tab;

    public static void copyToClipboard(JTable ctaable) {
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < ctaable.getSelectedRows().length; i++) {
            str.append(ctaable.getValueAt(ctaable.getSelectedRows()[i], 0));
        }
        StringSelection strsel = new StringSelection(str.toString());
        clipboard.setContents(strsel, strsel);
        System.out.println("expected: " + str.toString());
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Object[][] data = {{1, 2, 3}, {5, 6, 7}, {8, 9, 0}};
        tab = new JTable(data, new String[]{"a", "b", "c"});

        tab.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK, true), "CTRL C");
        tab.getActionMap().put("CTRL C", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ClipboardTable.copyToClipboard(ClipboardTable.tab); // whole row is copied instead of only Cell
            }
        });

        jf.add(tab);
        jf.pack();
        jf.setVisible(true);
    }
}