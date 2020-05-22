class WindowLauncherClass {

   SortedSet set = null;
   Iterator setIterator = null;

   public WindowLauncherClass(SortedSet set) {
      this.set = set; // or you can copy it if that's what you need.
   }

   protected void launchWindow(Object item) {
     // impl 
   }

   public void onActivityResult() {
      if ( setIterator != null && setIterator.hasNext() ) 
      {   
         launchWindow(setIterator.next());
      }
   }

   public void start() {
       setIterator = set.iterator();
       onActivityResult();
   }
}