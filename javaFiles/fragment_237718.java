import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Contacts {

    private List<String> names;

    //either to help your understanding and for sake of simplicity
    public Contacts() {
        this.names = new ArrayList<String>();
        this.names.add("name1");
        this.names.add("name2");

    }

    //clean the content of names from names List
    public void cleanNames(){
        if (Objects.nonNull(names)) {
            this.names.clear();
        }
    }

    //add a name to list
    public void addName(String name) {
        if (Objects.nonNull(names)) {
            this.names.add(name);
        } else {
            this.names = new ArrayList<>();
            this.names.add(name);
        }
    }

    //set a entire list to names attribute
    public void setNames(List<String> names) {
        this.names = names;
    }

    //get the name attribute
    public List<String> getNames() {
        if (Objects.nonNull(names)) {
            return this.names;
        } else {
            this.names = new ArrayList<>();
            return names;
        }
    }

}