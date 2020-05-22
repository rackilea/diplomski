public class PO extends CMS<POL> {
    private List<POL> lpol = new ArrayList<>();

    public List<POL> getLpo() {
        return lpol;
    }

    public void setLpo(List<POL> lpol) {
        this.lpol = lpol;
    }

    @Override
    public void attach(POL childNode) {
        getLpo().add(childNode);

    }
}