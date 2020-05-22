@Entity
@Table(name = "posix_user")
public class PosixUserEntity {

     @Id
     @Column(name = "user_id")
     private Long user_id;

     // getter + setter
}

@Entity
@Table(name = "postgre_user")
public class UserEntity {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private String name;

     @OneToOne(cascade=CascadeType.ALL)
     @PrimaryKeyJoinColumn
     private PosixUser posixUserEntity;

     // getter + setter
}