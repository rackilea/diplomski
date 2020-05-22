/**
    * Removes a reference for cycle detection check.
    */
   protected static void removeInstance( Object instance ) {
      Set set = getCycleSet();
      set.remove( instance );
      if(set.size() == 0) {
          cycleSet.remove();   // BUG @ "line 221"
      }
   }