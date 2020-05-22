import generated.EQHO;
import generated.HWData;
import generated.NE;
import generated.UNIT;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class HwDataTree extends DynamicTreeDemo {

    // the path of your XML file
    private static final String PATH = "C:/example.xml";

    @Override
    public void populateTree(DynamicTree treePanel) {
        HWData hwData = initData();
        treePanel.addObject(null, formatHeader(hwData));
        treePanel.addObject(null, formatNE(hwData));
        addNodesRecursive(hwData.getNE(), null, treePanel);
    }

    private HWData initData() {
        try {
            File xml = new File(PATH);
            JAXBContext jaxbContext = JAXBContext.newInstance(HWData.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (HWData) jaxbUnmarshaller.unmarshal(xml);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void addNodesRecursive(NE parent, DefaultMutableTreeNode parentNode, DynamicTree treePanel) {
        List<EQHO> children = parent.getEQHO();
        for (EQHO child : children) {
            DefaultMutableTreeNode childNode = treePanel.addObject(parentNode, formatEQHO(child));
            addNodesRecursive(child, childNode, treePanel);
        }
    }

    private void addNodesRecursive(EQHO parent, DefaultMutableTreeNode parentNode, DynamicTree treePanel) {
        List<Object> children = parent.getEQHOAndUNIT();
        for (Object child : children) {
            DefaultMutableTreeNode childNode = treePanel.addObject(parentNode, getMOID(child));
            if (child instanceof EQHO) {
                EQHO eqho = (EQHO) child;
                addNodesRecursive(eqho, childNode, treePanel);
            }
        }
    }

    private String getMOID(Object child) {
        String moid;
        if (child instanceof EQHO) {
            EQHO eqho = (EQHO) child;
            moid = formatEQHO(eqho);
        } else if (child instanceof UNIT) {
            UNIT unit = (UNIT) child;
            moid = formatUnit(unit);
        } else {
            throw new RuntimeException("Could not parse type of: " + child);
        }
        return moid;
    }

    private String formatHeader(HWData hwData) {
        return String.format("Header time=%s", hwData.getHeader().getTime());
    }

    private String formatNE(HWData hwData) {
        return String.format("NE MOID=%s", hwData.getNE().getMOID());
    }

    private String formatEQHO(EQHO child) {
        return String.format("EQHO MOID=%s", child.getMOID());
    }

    private String formatUnit(UNIT unit) {
        return String.format("UNIT MOID=%s", unit.getMOID());
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HwDataTree newContentPane = new HwDataTree();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
}