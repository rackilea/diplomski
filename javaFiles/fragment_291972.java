public class DDT {

    //...

    private final ObservableList<DDTItem> rows;

    // ...


    public DDT() {

        // ...

        this.rows = FXCollections.observableArrayList();

        // ...
    }


    public ObservableList<DDTItem> getRows() {
        return rows.get();
    }

    // ...
}