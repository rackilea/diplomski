@Table
@Entity(name='Likes')
public class LikesEntity implements Serializable {

    @Transient
    private List<String> userIds;
    @Column
    private String likes;
    @Column
    private String count;

     //getter and setters for the like and count
    ...
    public void addUserId(String id){
        this.userIds.add(userIds);
        this.likes = convertToJsonArray(userIds); // use GSON or Jackson or any other library that can help you convert array to JSON string
        this.count = this.userIds.size();
    } 


}