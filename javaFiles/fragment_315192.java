@Entity(name = "Person")
public class Person{
    @Column(name = "iAge")
    @JsonProperty("age")
    private int _age;
}