DefaultListModel d = new DefaultListModel();
d.addElement("first value");
d.addElement("second value");

final JList list = new JList(d);

list.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            int index = list.locationToIndex(e.getPoint());
            System.out.println("Double clicked on Item " + index);

            //??????? CHANGEVALUE(index,"MY NEW VALUE); ????????
            d.setElementAt("MY NEW VALUE", index);
        }
    }
});
JOptionPane jpane = new JOptionPane();
jpane.showMessageDialog(null, list, "MYTITLE", JOptionPane.PLAIN_MESSAGE);