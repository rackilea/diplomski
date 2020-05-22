public class GenreManager{
   private SortedSet<Genre> genres;
   ...

   public GenreManager(Collection<Genre> genres){
     this.genres = new TreeSet<>( genres );
   }
}