public class Movies extends javax.swing.JFrame {
    public Movies() {
        initComponents();
        table.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer("1.jpg"));
        table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer("2.jpg"));
    }
}

class ImageRenderer extends DefaultTableCellRenderer {
    ImageIcon icon = null;    

    ImageRenderer(String iconName) {
        icon = new ImageIcon(getClass().getResource(iconName));
    }
}