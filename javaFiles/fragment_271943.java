public class UserRepoImpl implements UserCustomMethods{

    //This is my tip, but not a must...
    @PersistenceContext
    private EntityManager em;

    public void mySave(User... users){
        //do what you need here
    }
}