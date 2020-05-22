import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DepartmentList
{

    public static ObservableList<Department> getDepartmentList()
    {
        Department fruit = new Department("Fruit");
        Department vegetables = new Department("Vegetables");
        Department beverages = new Department("Beverages");

        ObservableList<Department> list;
        list = FXCollections.observableArrayList(fruit, vegetables,
                beverages);

        return list;
    }
}