public class Dialog extends javax.swing.JDialog {

    public Dialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        final int h = getHeight();
        addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                Rectangle b = getBounds();
                if (b.height != h) {
                    b.height = h;
                    setBounds(b);
                }
                super.componentResized(e);
            }
        });
    }
}