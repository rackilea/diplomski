public class Location {
   private int id;
   // more stuff here

   private Predicate<Integer> filter;
     public Location() {
          this.filter = TruePredicate.INSTANCE; 
     }
     public Location(int idFilter) {
             this.filter = new EqualPrediate(idFilter);
     }

     public String toString() {
       StringBuilder buffer = new StringBuilder();
          if(filter.apply(this.id)) { 
             buffer.append("Location [location=" + Arrays.toString(location) + ", id=" + id
                + ", description=" + description + ", weight=" + weight
                + ", name=" + name + ", exit=" + Arrays.toString(exit)
                +"]");
          }
       return buffer.toString();
     }

}