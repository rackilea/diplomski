@Entity
public class User implements Serializable {
   @ManyToMany(mappedBy="followers")
   @JoinTable(name="followingTable")
   private Set<User> following;
   @ManyToMany
   @JoinTable(name="followerTable")
   private Set<User> followers;
   @ManyToMany(mappedBy="friendRequests")
   @JoinTable(name="requestingTable")
   private Set<User> requesting;
   @ManyToMany
   @JoinTable(name="friendRequestTable")
   private Set<User> friendRequests;
   @ManyToMany
   private Set<User> friends;
}