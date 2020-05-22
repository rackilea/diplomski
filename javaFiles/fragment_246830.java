import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;

public class FontEquivalence {

    public boolean fontsAreEquivalentForText(Font f1, Font f2, String text) {
        Area area1 = new Area(
                f1.deriveFont(25f).
                createGlyphVector(fontRenderContext, text).
                getOutline());
        Area area2 = new Area(
                f2.deriveFont(25f).
                createGlyphVector(fontRenderContext, text).
                getOutline());
        return area2.equals(area1);
    }

    public void findEquivalentFonts(final Font font) {
        if (dialog == null) {
            dialog = getDialog(ui);
        }
        fontChecker = new SwingWorker() {

            @Override
            protected Object doInBackground() throws Exception {
                dialog.setLocationRelativeTo(ui);
                sameFontListModel.clear();
                String s = inputString.getText();
                int fontNumber = fonts.length;
                progress.setMaximum(fontNumber);
                int ii = 1;
                for (Font f : fonts) {
                    if (fontsAreEquivalentForText(f, font, s)) {
                        sameFontListModel.addElement(f);
                    }
                    progress.setValue(ii++);
                    if (fontChecker.isCancelled()) {
                        break;
                    }
                }
                dialog.setVisible(false);
                return null;
            }
        };
        fontChecker.execute();
        dialog.setVisible(true);
    }

    public JDialog getDialog(JComponent comp) {
        Container cont = comp.getTopLevelAncestor();
        Frame f = null;
        if (cont instanceof Frame) {
            f = (Frame) cont;
        }
        final JDialog d = new JDialog(f, 
                "Searching " + fonts.length + " fonts for equivalents..", 
                true);
        JPanel p = new JPanel(new BorderLayout(15, 15));
        p.setBorder(new EmptyBorder(40, 100, 40, 100));
        p.add(progress, BorderLayout.CENTER);

        JButton cancel = new JButton("Cancel");
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fontChecker.cancel(true);

                d.setVisible(false);
            }
        };
        cancel.addActionListener(al);
        JPanel control = new JPanel(new FlowLayout(FlowLayout.CENTER));
        control.add(cancel);
        p.add(control, BorderLayout.PAGE_END);

        d.add(p);
        d.pack();

        return d;
    }

    public JComponent getUI() {
        if (ui == null) {
            ui = new JPanel(new BorderLayout(2, 2));
            inputString = new JTextField(text, 15);
            inputString.setFont(inputString.getFont().deriveFont(20f));
            ui.add(inputString, BorderLayout.PAGE_START);
            GraphicsEnvironment ge = GraphicsEnvironment.
                    getLocalGraphicsEnvironment();
            fonts = ge.getAllFonts();
            final JList fontList = new JList(fonts);
            ListSelectionListener lsl = new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        Font font = (Font) fontList.getSelectedValue();
                        findEquivalentFonts(font);
                    }
                }
            };
            fontList.addListSelectionListener(lsl);
            fontList.setCellRenderer(new FontCellRenderer());
            fontList.setVisibleRowCount(15);
            ui.add(new JScrollPane(fontList), BorderLayout.LINE_START);

            JList list = new JList(sameFontListModel);
            list.setCellRenderer(new FontCellRenderer());
            ui.add(new JScrollPane(list));

            BufferedImage bi = new BufferedImage(
                    1, 1, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bi.createGraphics();
            fontRenderContext = g.getFontRenderContext();

            progress = new JProgressBar(0, fonts.length);
            progress.setStringPainted(true);
        }
        return ui;
    }

    JPanel ui = null;
    JTextField inputString;
    String text = "The quick brown fox jumps over the lazy dog.";
    Font[] fonts;
    DefaultListModel sameFontListModel = new DefaultListModel();
    FontRenderContext fontRenderContext;
    JDialog dialog;
    SwingWorker fontChecker;
    JProgressBar progress;

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame("Font Equivalence");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setContentPane(new FontEquivalence().getUI());
                f.pack();
                f.setLocationByPlatform(true);
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}

class FontCellRenderer extends DefaultListCellRenderer {

    public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(
                list, value, index, isSelected, cellHasFocus);
        Font font = (Font) value;
        label.setFont(font.deriveFont(20f));
        label.setText(font.getName());
        return label;
    }
}