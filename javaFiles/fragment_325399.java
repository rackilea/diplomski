public class FormBean {

    private List<List<Boolean>> matrix;

    FormBean() { }

    public FormBean(List<List<Boolean>> matrix) {
        this.matrix = matrix;
    }

    public List<List<Boolean>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<Boolean>> matrix) {
        this.matrix = matrix;
    }
}