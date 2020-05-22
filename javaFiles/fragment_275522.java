package populatetable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Data {

    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;


    public Data(int id, String name) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int ID) {
        id.set(ID);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String nme) {
        name.set(nme);
    }

    @Override
    public String toString() {
        return "id: " + id.get() + " - " + "name: " + name.get();
    }

}