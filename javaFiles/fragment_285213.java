JPopupMenu menu1 = new JPopupMenu();
menu1.add(new JMenuItem("Item1"));
menu1.add(new JMenuItem("Item2"));
countItems(menu1);
JMenu menu2 = new JMenu();
menu2.add(new JMenuItem("Item1"));
menu2.add(new JMenuItem("Item2"));
countItems(menu2.getPopupMenu());//Use the JPopupMenu rather than the JMenu itself)

private static final void countItems(JPopupMenu menu){
    System.out.println("COUNT: " + menu.getComponents().length);
}