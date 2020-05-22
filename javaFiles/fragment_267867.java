public class TravelRow {
   String organization;
   String address;
   String reviewer;
   String reviewTitle;
   String review; // you get it... 

   public TravelRow(String[] row) {
       // assign row-index to property
       this.organization = row[0];
       // you get it ...
   }
}