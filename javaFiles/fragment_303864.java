public class ExpandListGroup {

private String Name;
private ArrayList<ExpandListChild> Items;

public ExpandListGroup(String name, ArrayList<ExpandListChild> items) {
    super();
    Name = name;
    Items = items;
}

public String getName() {
    return Name;
}

public void setName(String name) {
    Name = name;
}

public ArrayList<ExpandListChild> getItems() {
    return Items;
}

public void setItems(ArrayList<ExpandListChild> items) {
    Items = items;
}

}