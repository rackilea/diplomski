public class WarehouseTab extends JPanel {
    public WarehouseTab() {
        setLayout(new BorderLayout());
        add(new JScrollPane(new WarehousePane());
    }
}

public class WarehousePane extends JPanel {
    WarehousePane(){
        setLayout(...); // Set an appropriate layout for overall needs
        this.add(new WarehouseItem());
        this.add(new WarehouseItem());
        this.add(new WarehouseItem());
    }