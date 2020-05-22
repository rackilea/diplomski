JTable table=new JTable(myModel){
 public boolean getScrollableTracksViewportWidth() {
   return getPreferredSize().width < getParent().getWidth();
 }
};
JScrollPane scroll=new JScrollPane(table);