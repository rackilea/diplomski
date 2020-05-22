@Embeddable
public class CitySet implements Serializable {

@ManyToOne
@JoinColumn(name = "fk_city1")
private City city1;

@ManyToOne
@JoinColumn(name = "fk_city2")
private City city2;
}