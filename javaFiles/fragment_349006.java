import java.util.ArrayList;
import java.util.List;

public class GameCharacter {
private int xpos;
private int ypos;
private String name;
private int rowSize;
private int columnSize;

private List<String> inventory = new ArrayList<>();

// Constructor
GameCharacter(String n, int rSize, int cSize) {
    this.xpos = 0;
    this.ypos = 0;
    this.name = n;
    this.rowSize = rSize;
    this.columnSize = cSize;
}

GameCharacter() {
    this.xpos = 0;
    this.ypos = 0;
    this.name = "billybob";
    this.rowSize = 10;
    this.columnSize = 10;
}

public int getXpos() {
    return xpos;
}

public void setXpos(int xpos) {
    this.xpos = xpos;
}

public int getYpos() {
    return ypos;
}

public void setYpos(int ypos) {
    this.ypos = ypos;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public int getRowSize() {
    return rowSize;
}

public void setRowSize(int rowSize) {
    this.rowSize = rowSize;
}

public int getColumnSize() {
    return columnSize;
}

public void setColumnSize(int columnSize) {
    this.columnSize = columnSize;
}

public List<String> getInventory() {
    return inventory;
}

public void setInventory(List<String> inventory) {
    this.inventory = inventory;
}

}