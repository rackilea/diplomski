public class TranslucentTable extends JTable {

    public TranslucentTable() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(getBackground());
        g2d.fill(new Rectangle(0, 0, getWidth(), getHeight()));
        getUI().paint(g2d, this);
        g2d.dispose();
    }

    @Override
    protected JTableHeader createDefaultTableHeader() {
        JTableHeader header = new TranslucentTableHeader();
        header.setColumnModel(getColumnModel());
        return header;
    }



}