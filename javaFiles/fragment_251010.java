@Entity(name = "USERS")
@Table(name = "USERS")
@Setter
@Getter
public class User {

 @Id
 @SequenceGenerator(name = "ID_GENERATOR", sequenceName = "ID_SEQUENCE")
 @GeneratedValue(generator = "ID_GENERATOR" )
 @Column(name = "SSO_ID")
 private Long ssoId;

 @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
 private List<UserEmail> userEmails = new ArrayList<>();

}



@Setter
@Getter
@Entity(name = "USER_EMAILS")
@Table(name = "USER_EMAILS")
@IdClass(UserEmailId.class)
public class UserEmail {


 @Id
 @Column(name = "USER_MAIL")
 private String userMail;

 @Id
 @Column(name = "START_DATE")
 private Date startDate;

 @Id
 @Column(name = "EMAIL_TYPE")
 private String emailType;

 @ManyToOne(fetch = FetchType.LAZY)
 private User user;

}


@Setter
@Getter
public class UserEmailId implements Serializable {

  private String userMail;
  private Date startDate;
  private String emailType;

}


public class SomeClass{ 

 public User saveUser(){
     User user = new User();
     UserEmail userEmail = new UserEmail();
     userEmail.setUser(user);
     userEmail.setEmailType("type");
     userEmail.setStartDate(new Date());
     userEmail.setUserMail("someEmail@gmail.com");
     user.setUserEmails(Arrays.asList(userEmail));
     userRepo.save(user);
    }
}