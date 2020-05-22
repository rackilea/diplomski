import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;

public class WhiteSpace {

    private JPanel gui = null;
    private BorderLayout mainLayout = 
        new BorderLayout(0, 0);
    private final FlowLayout buttonLayout = 
            new FlowLayout(FlowLayout.CENTER, 0, 0);
    private final JPanel buttonPanel = new JPanel(buttonLayout);
    private final SpinnerNumberModel hModel = 
            new SpinnerNumberModel(0, 0, 15, 1);
    private final SpinnerNumberModel vModel = 
            new SpinnerNumberModel(0, 0, 15, 1);
    private final SpinnerNumberModel hBorderModel = 
            new SpinnerNumberModel(0, 0, 15, 1);
    private final SpinnerNumberModel vBorderModel = 
            new SpinnerNumberModel(0, 0, 15, 1);
    private ChangeListener changeListener;

    public Container getGui() {
        if (gui == null) {
            gui = new JPanel(mainLayout);
            gui.setBackground(Color.RED);

            JTree tree = new JTree();
            tree.setVisibleRowCount(10);
            for (int ii = tree.getRowCount(); ii > -1; ii--) {
                tree.expandRow(ii);
            }
            gui.add(new JScrollPane(
                    tree,
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),
                    BorderLayout.LINE_START);
            gui.add(new JScrollPane(new JTextArea(10, 30)));

            gui.add(buttonPanel, BorderLayout.PAGE_START);

            changeListener = (ChangeEvent e) -> {
                int hGap = hModel.getNumber().intValue();
                int vGap = vModel.getNumber().intValue();
                int hBorder = hBorderModel.getNumber().intValue();
                int vBorder = vBorderModel.getNumber().intValue();
                adjustWhiteSpace(hGap, vGap, hBorder, vBorder);
            };

            addModel("H Gap", hModel);
            addModel("V Gap", vModel);
            addModel("H Border", hBorderModel);
            addModel("V Border", vBorderModel);
        }

        return gui;
    }

    private void addModel(String label, SpinnerNumberModel model) {
        buttonPanel.add(new JLabel(label));
        final JSpinner spinner = new JSpinner(model);
        spinner.addChangeListener(changeListener);
        buttonPanel.add(spinner);
    }

    private void adjustWhiteSpace(
            int hGap, int vGap, int hBorder, int vBorder) {
        mainLayout.setHgap(hGap);
        mainLayout.setVgap(vGap);
        buttonLayout.setHgap(hGap);
        gui.setBorder(new EmptyBorder
                (vBorder, hBorder, vBorder, hBorder));
        Container c = gui.getTopLevelAncestor();
        if (c instanceof Window) {
            Window w = (Window) c;
            w.pack();
        }
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            WhiteSpace ws = new WhiteSpace();
            Container gui1 = ws.getGui();
            JFrame f = new JFrame("White (OK Red) Space");
            f.add(gui1);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setLocationByPlatform(true);
            f.setResizable(false);
            f.pack();
            f.setVisible(true);
        };
        SwingUtilities.invokeLater(r);
    }
}