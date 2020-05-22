//Container.java (1751 ~ 1800)
public Dimension getPreferredSize() {
   return preferredSize();
}

@Deprecated
public Dimension preferredSize() {
   Dimension dim = prefSize;
   if (dim == null || !(isPreferredSizeSet() || isValid())) {
       synchronized (getTreeLock()) {
           prefSize = (layoutMgr != null) ?
               layoutMgr.preferredLayoutSize(this) :
               super.preferredSize();
           dim = prefSize;
       }
   }

   if (dim != null){
       return new Dimension(dim);
   }
   else{
       return dim;
   }
}