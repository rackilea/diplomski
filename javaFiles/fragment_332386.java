@Entity
public class SuperUser extends User {   
   ...
}

@Entity
public class BasicUser extends User {   
   ...
}

@MappedSuperclass
public abstract class User implements Serializable {      

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "website_uuid", nullable = false)
    protected Website website;

    ...   
}

@Entity
public class Website implements Serializable {   

   ...
}


@Repository
public interface SuperUserRepository extends CrudRepository<SuperUser, Long> {

   Iterable<SuperUser> findByWebsite(Website website);

}

@Repository
public interface BasicUserRepository extends CrudRepository<BasicUser, Long> {

   Iterable<BasicUser> findByWebsite(Website website);

}