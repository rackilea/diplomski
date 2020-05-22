@ManagedBean
public class Simplebean {

    private Fruit selectedFruit;

    public Fruit getSelectedFruit() {
        return selectedFruit;
    }

    public void setSelectedFruit(Fruit selectedFruit) {
        this.selectedFruit = selectedFruit;
    }

    public Fruit[] getFruits() {
        return Fruit.values();
    }
}