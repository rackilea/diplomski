public final class Main {

 public static void main(String[] args) {
   SwingUtilities.invokeLater(new Runnable() {
     public void run() {
       JFrame frame = new JFrame();
       frame.setSize(500, 500);
       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       JList<Object> view = new JList<Object>();
       view.setSelectionModel(new NoSelectionModel());
       view.setListData(new Object[] {"String 1 ", "String 2"});
       frame.getContentPane().add(new JScrollPane(view));

       frame.setVisible(true);
     }
   });
 }

 private static class NoSelectionModel extends DefaultListSelectionModel {

   @Override
   public void setAnchorSelectionIndex(final int anchorIndex) {}

   @Override
   public void setLeadAnchorNotificationEnabled(final boolean flag) {}

   @Override
   public void setLeadSelectionIndex(final int leadIndex) {}

   @Override
   public void setSelectionInterval(final int index0, final int index1) { }
 }
}