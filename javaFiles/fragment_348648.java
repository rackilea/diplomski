@Entity
public class UserImage{

    @ManyToOne
    private User user;

    public User getUser(){return user;}
    public setUser(User user){this.user = user;}

}

@Entity
public class User{

    @OneToMany(mappedBy="user")
    private Set<UserImage> images;

    public void setImages(Set<UserImage> images){this.images=images;}
    public Set<UserImage> getImages(){return this.images;}

}