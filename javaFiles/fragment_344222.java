@DynamoDBTable
public class Model {

    private Integer id;
    private String title;

    @DynamoDBHashKey  
    public Integer getId() { return id;}
    public void setId(Integer id) {this.id = id;}

    @DynamoDBAttribute 
    public String getTitle() {return title; }
    public void setTitle(String title) { this.title = title; }
}