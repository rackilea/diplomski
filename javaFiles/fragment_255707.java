private static class CycleSet extends ThreadLocal {
      protected Object initialValue() {
         return new SoftReference(new HashSet());
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