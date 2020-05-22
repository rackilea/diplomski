import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FormulaWindow extends JDialog {

    public FormulaWindow(final Window parent) {
        super(parent, "Formula window", ModalityType.MODELESS);
        final Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setSize(500, 400);
        final Map<String, String> formulaDescritions = new HashMap<>();
        formulaDescritions.put("Formula 1", "<html>How the world works.</html>");
        formulaDescritions.put("Formula 2", "<html>How woman work.</html>");
        formulaDescritions.put("Formula 3", "<html>How programming works.</html>");
        final JList<String> formulaList = new JList<String>(new Vector<String>(formulaDescritions.keySet()));
        formulaList.setPreferredSize(new Dimension(100, 100));
        final JLabel descriptionLabel = new JLabel();
        descriptionLabel.setVerticalAlignment(SwingConstants.TOP);
        formulaList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                final JList<String> list = (JList<String>) evt.getSource();
                descriptionLabel.setText(formulaDescritions.get(list.getSelectedValue()));
            }
        });
        cp.add(new JScrollPane(formulaList), BorderLayout.WEST);
        cp.add(new JScrollPane(descriptionLabel), BorderLayout.CENTER);
    }
}