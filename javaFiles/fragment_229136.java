public class Joke {

    @JsonIgnoreProperties("jokes")
    public Set<User> getUsers(){
        return this.users;
    }    
}