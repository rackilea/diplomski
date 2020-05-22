@Entity
public class User {
   @OneToMany()
   public Collection<Comment> comments;
   ...
}

@Entity
public class Comment {
   @ManyToOne
   @JoinColumn(name="user_fk")
   public User user;
   ...
}