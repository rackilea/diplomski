@Repository
public interface UserRepository extends Neo4jRepository<User> {

    @Query("MATCH (user:User{id:{id}})-[has:HAS]->(socialUser:SocialUser) DELETE user, has, socialUser")
    void delete(String id);
}