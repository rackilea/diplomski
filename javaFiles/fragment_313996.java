Group[] groups = {
   new Group("Order", new Milestone[] {
      new Milestone("Tested","testedDate"),
      new Milestone("Created", new Milestone[] {
         new Milestone("Delivered,"deliveredDate"),
         new Milestone("Pressed,"someString"),
         new Milestone("Assembled,"whatever")}),
      new Milestone("Ordered","something")
   }
   new Group("Invoice",...
   ...
   ...
};