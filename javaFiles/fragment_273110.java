public class SubModel {

    private LongProperty id;
    private DoubleProperty xAmount;
    private DoubleProperty yAmount;

    public SubModel(Long id, Double xAmount, Double yAmount) {
        this.id = new SimpleLongProperty(id);
        this.xAmount = new SimpleDoubleProperty(xAmount);
        this.yAmount = new SimpleDoubleProperty(yAmount);
    }

    public long getId() {
        return id.get();
    }


    public double getxAmount() {
        return xAmount.get();
    }

    public DoubleProperty xAmountProperty() {
        return xAmount;
    }

    public double getyAmount() {
        return yAmount.get();
    }

    public DoubleProperty yAmountProperty() {
        return yAmount;
    }
}