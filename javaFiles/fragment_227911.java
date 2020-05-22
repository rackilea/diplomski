//Existing BackOfficeUser, @Inheritance is added
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BackOfficeUser {
    @Id private Integer id;
}


//New class that extends BackOfficeUser. Will have dedicated
//table for added persistent attributes, shared attributes
//are persisted to existing table "BackOfficeUser"
@Entity
public class XxxBackOfficeUser extends BackOfficeUser {
    private String someAttribute

    @ManyToMany (mappedBy = "xxxBackOfficeUsers")
    private List<Rule> rules;
}

//New entity class which does have relation to XxxBackOfficeUser
@Entity
public class Rule {
    @Id private Integer id;

    @ManyToMany
    private List<XxxBackOfficeUser> xxxBackOfficeUsers;
}