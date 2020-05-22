@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="breakfast_menu")
public class BreakfastMenu {


@XmlElement(name="food", type=Food.class)
private List<Food> food  = new ArrayList<Food>();

public List<Food> getFood() {
    return food;
}

public void setFood(List<Food> food) {
this.food = food;
}
}