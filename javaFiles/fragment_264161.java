/**
 * This method gets the first entity having email. It uses HTTP GET
 * method.
 * 
 * @param email
 *            
 * @return The entity with email.
 */
@ApiMethod(name = "getUserByEmail", path="getUserByEmail")
public User getUserByEmail(@Named("email") String email) {
    EntityManager mgr = getEntityManager();
    User user = null;
    try {
        //Query query = mgr.createQuery("SELECT u FROM User u WHERE u.email = '" + email + "'");
        Query query = mgr.createQuery("SELECT FROM User u WHERE u.email = :email");
        query.setParameter("email", email);
        user = (User) query.getSingleResult();
    } finally {
        mgr.close();
    }
    return user;
}