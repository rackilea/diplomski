//Component.java (2560 ~ 2585)
public void setPreferredSize(Dimension preferredSize) {
   Dimension old;
   if (prefSizeSet) {
       old = this.prefSize;
   }
   else {
       old = null;
   }

   this.prefSize = preferredSize;
   prefSizeSet = (preferredSize != null);
   firePropertyChange("preferredSize", old, preferredSize);
}