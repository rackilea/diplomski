public class NoRepeatButtonGroup implements ActionListener {
   private List<AbstractButton> btnList = new ArrayList<>();

   public void add(AbstractButton btn) {
      btnList.add(btn);
      btn.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent evt) {
      for (AbstractButton btn : btnList) {
         btn.setEnabled(true);
      }
      ((AbstractButton) evt.getSource()).setEnabled(false);
   }

   public void reset() {
      for (AbstractButton btn : btnList) {
         btn.setEnabled(true);
      }
   }
}