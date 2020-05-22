public class MyEntryRepresentation {
   protected String dateStr;

   // ArrayList: faster iteration by position
   // LinkedList: memory conservative - doesn't allocate more than necessary
   protected List<ExpectedVsActual> data;

   public MyEntryRepresentation(String date) 
     this.dateStr=date;
     this.data=new ArrayList<ExpectedVsActual>();
   }

   public void addEntry(int expected, int actual) {
     this.data.add(new ExpectedVsActual(expected, actual));
   }

   public List<ExpectedVsActual> getValues() {
     // if you don't care what the caller will do with your List 
     return this.data;
     // If you want to forbid them to modify the returned list
     // return Collections.unmodifiableList(this.data);
   }

   public String getDateStr() {
     return this.date;
   }
}