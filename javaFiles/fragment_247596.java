@Entity(name="DISTANCE")
@Table(name="DISTANCE")
@IdClass(CitySet.class)
public class Distance {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int num;

@Id
private City city1;

@Id
private City city2;

private float distance;

}