interface IPlotter {
    List<? extends ILayer> getLayers();
}

class Plotter implements IPlotter {
    private ObservableList<Layer> layers = FXCollections.observableArrayList();

    @Override
    public List<? extends ILayer> getLayers() {
        return layers;
    }
}