@Component
public class userDao{
       @AutoWired
       private SessionFactory sessionFactory;


       @Transactional
       public User findByIdAndPassword(String id , String password){
             ....
       }

       {getters and setters}

}