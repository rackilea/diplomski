public class User {

    @JsonIgnoreProperties("users")
    public Set<Joke> getJokes(){
        return this.jokes;
    }    
}