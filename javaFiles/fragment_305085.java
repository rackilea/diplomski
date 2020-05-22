@Entity
@Where(clause="is_active=1")
public class Dog{

......(fields)....        

@Column(name="is_active")
private Boolean active;
}