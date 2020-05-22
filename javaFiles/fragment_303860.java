public class Item {

    public Item(String baseFormula, String basePt) {
        this.baseFormula = new SimpleStringProperty(baseFormula);
        this.basePt = new SimpleStringProperty(basePt);
    }

    private final StringProperty basePt;
    private final StringProperty baseFormula;

    public final String getBaseFormula() {
        return this.baseFormula.get();
    }

    public final void setBaseFormula(String value) {
        this.baseFormula.set(value);
    }

    public final StringProperty baseFormulaProperty() {
        return this.baseFormula;
    }

    public final String getBasePt() {
        return this.basePt.get();
    }

    public final void setBasePt(String value) {
        this.basePt.set(value);
    }

    public final StringProperty basePtProperty() {
        return this.basePt;
    }

    @Override
    public String toString() {
        return "Item{" + "basePt=" + basePt.get() + ", baseFormula=" + baseFormula.get() + '}';
    }

}