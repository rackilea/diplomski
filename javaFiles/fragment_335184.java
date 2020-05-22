interface UserRepository {
//...
}

interface UserMySqlRepository extends UserRepository {
//...
}

interface UserMongoDBRepository extends UserRepository {
//...
}

@Configuration
class DbBeansConfig{

@Bean
public UserRepository getUserRepository(){

  if(mysql configured){// give your impl here
     return new UserMySqlRepository(); // your bean here
   }else{
      return new UserMongoDBRepository (); // your bean here
   }
 }
}