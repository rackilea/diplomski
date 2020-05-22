JTable table = new JTable(model);

JPopupMenu popupMenu = new JPopupMenu();
JMenuItem mi = popupMenu.add("Boo!");
mi.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Ah, a ghost!");
    }
});
table.setComponentPopupMenu(popupMenu);