import java.io.Serializable;
public class Service implements Serializable
{

private static final long serialVersionUID = 1L;

private String name;
private boolean selected;

public Service() {
    // TODO Auto-generated constructor stub
}

public Service(String name) {
    super();
    this.name = name;
}


public String getName() {
    return name;
}

public boolean isSelected() {
    return selected;
}

public void setSelected(boolean selected) {
    this.selected = selected;
}

public void setName(String name) {
    this.name = name;

}