import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FruitList
{

    public static ObservableList<Fruit> getFruitList()
    {
        Fruit apple = new Fruit("Apple");
        Fruit orange = new Fruit("Orange");
        Fruit tomato = new Fruit("Tomato");

        ObservableList<Fruit> list;
        list = FXCollections.observableArrayList(apple, orange,
                tomato);

        return list;
    }
}