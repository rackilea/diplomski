private static class CycleSet extends ThreadLocal {
      protected Object initialValue() {
         return new SoftReference(new HashSet());
      }
      /** added to support JRE 1.3 */
      public void remove() {
          this.set(null);
      }
      public Set getSet() {
         Set set = (Set) ((SoftReference)get()).get();
         if( set == null ) {
             set = new HashSet();
             set(new SoftReference(set));
         }
         return set;
      }
   }