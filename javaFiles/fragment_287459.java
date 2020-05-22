package my.menu;
import java.util.LinkedList;

public class MenuNode{
    private MenuNode parent;
    private LinkedList<MenuNode> children;

    private String name;
    private int id;

    public MenuNode(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public MenuNode getParent() {
        return parent;
    }

    public void setParent(MenuNode parent) {
        this.parent = parent;
    }

    public void addChild(MenuNode child) {
        children.add(child);
        child.setParent(this);
    }

    public LinkedList<MenuNode> getChildren() {
        return children;
    }
}