@Entity
public class Tests{

private int id;

@ManyToOne
private Quiz quiz;

@ManyToOne
private User user;

private int score;

private String status; // failed or passed

}