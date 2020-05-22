public interface UserRepository extends MongoRepository<UserId, String> {
{

    public List<Users> findByNameLike(String username);

}