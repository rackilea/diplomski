enum Category {
   Approved  {
      @Override 
      public Group select(A a) {
           return Group.ApprovedGroup;
      }
   },
   Suppressed  {
      @Override 
      public Group select(A a) {
           return Group.SuppressedGroup;
      }
   },
   Rejected  {
      @Override 
      public Group select(A a) {
           ...
           return Group.BlockRejectedGroup;
           ...
           return Group.ActionRejectedGroup;
      }
   };

   public abstract Group select(A a);
}