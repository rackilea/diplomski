@Autowired
@Qualifier("nasigoreng")
private Food food;

public void setFood(Food food) {
    this.food = food;
}