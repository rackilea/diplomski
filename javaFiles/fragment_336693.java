public class MeasureController implements Initializable {

    private final ReadOnlyDoubleWrapper retdx = new ReadOnlyDoubleWrapper();

    public double getRetdx() {
        return retdx.get();
    }

    public ReadOnlyDoubleProperty retdxProperty() {
        retrun retdx.getReadOnlyProperty​();
    }

    private void dxCalc() { // should there be access to this method from outside this class? imho no -> private
        double dx = 5;
        retdx.set(dx);
    }

    @FXML
    void fireMeasure(ActionEvent event) {
        dxCalc();   
    }
}