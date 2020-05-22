private final IntegerProperty plast = new SimpleIntegerProperty(); 

public void setPlast(int plast) {
    this.plast.set(plast);
}

public int getPlast() {
    return plast.get();
}

// this method will be used by the PropertyValueFactory
// and returns a Property which notifies TableView of changes
public IntegerProperty plastProperty() {
    return plast;
}