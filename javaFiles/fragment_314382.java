@XmlRootElement
public class Order {
...
 @XmlElement
private List<Triplet> movies;

public List<Triplet> getMovies(){
  if(movies == null)
     movies = new ArrayList<Triplet>();

  return movies;
}
 ....
   //The setter for  movies isn't necessary because you can add new movies 
   //by calling getMovies().add(new Movie(1L,2,300.0));

}