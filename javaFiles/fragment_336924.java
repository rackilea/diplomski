public class Product extends CMS<PO> {
    private List<PO> lpo = new ArrayList<>();

    public List<PO> getLpo() {
        return lpo;
    }

    public void setLpo(List<PO> lpo) {
        this.lpo = lpo;
    }

    @Override
    public void attach(PO childNode) {
        getLpo().add(childNode);
    }
}