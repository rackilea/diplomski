public class GenreManager{
   private List<Genre> genres;
   ...

   public GenreManager(Collection<Genre> genres){
     ... 

     //create a list out of the passed collection
     this.genres = new ArrayList<Genre>( genres );

     //sort the list    
     Collections.sort(this.genres);
   }
}