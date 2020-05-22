public class Model {

    private LongProperty id;
    private DoubleProperty amount;
    private ObjectProperty<SubModel> subModel;

    public Model(Long id, Double amount, SubModel subModel) {
        this.id = new SimpleLongProperty(id);
        this.amount = new SimpleDoubleProperty(amount);
        this.subModel = new SimpleObjectProperty<>(subModel);
    }

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public DoubleProperty amountProperty() {
        return amount;
    }

    public SubModel getSubModel() {
        return subModel.get();
    }

    public ObjectProperty<SubModel> subModelProperty() {
        return subModel;
    }
}