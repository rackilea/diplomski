@Entity
public class User
{
    @OneToMany(mappedBy="user")
    private List<Location> locations;

    public List<Location> getLocations()
    {           
        return locations;
    }
}

@Entity
public class Location
{
    @ManyToOne
    @PrimaryKeyJoinColumn
    private User user;

    public User getUser()
    {
        return user;
    }
}