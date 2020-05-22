//JComponent.java (1642 ~ 1663)
public Dimension getPreferredSize() {
   if (isPreferredSizeSet()) {
       return super.getPreferredSize();
   }

   Dimension size = null;
   if (ui != null) {
       size = ui.getPreferredSize(this);
   }
   return (size != null) ? size : super.getPreferredSize();
}