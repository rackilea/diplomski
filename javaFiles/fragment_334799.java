import java.util.ArrayList;
import java.util.List;

public class Table {

    private int length, width;

    private List<List<String>> newTable;

    public Table() {
        this.length = this.width = 0;
    }

    /**
     * Testing a few functions
     */
    public static void main(String[] args) {
        // Just testing a few functions.
        Table list1 = new Table();
        list1.createTable(4, 4);
        list1.displayRow(1);
        System.out.println("displayRow done!");
        list1.displayColumn(1);
        System.out.println("displayColumn done!");
        list1.displayEntireTable();
        System.out.println("displayEntireTable done!");
    }

    public void createTable(int tableLength, int tableWidth) {
        length = tableLength;
        width = tableWidth;

        //by java 1.7 diamond feature, some generics can be hidden
        this.newTable = new ArrayList<>();
        for (int i = 0; i < tableWidth; i++) {
            List<String> columns = new ArrayList<>();
            for (int j = 0; j < tableLength; j++) {
                columns.add(new String("test"));
            } //added here
            this.newTable.add(columns);
        }
    }

    public void displayRow(int row) {
        System.out.println(this.newTable.get(row));
    }

    /**
     * This function displays the column of the table. Still work which
     * needs to be done here.
     * @param column 
     */
    public void displayColumn(int column) {
        for (int i = 0; i < this.newTable.size(); i++) {
            System.out.println("[" + this.newTable.get(i).get(column) + "]");
        }
    }

    public void displayEntireTable() {

        for (int i = 0; i < this.newTable.size(); i++) {
            System.out.println(this.newTable.get(i));
        }
    }
}