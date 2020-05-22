public AnimatedProgress(java.awt.Frame parent, boolean modal, JTable table)
{
    super(parent, modal);
    initComponents();
    setLocationRelativeTo(parent);
    setVisible(true);
    new BackgroundThread(table).execute();
}