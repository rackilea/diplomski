public class Model {

    private String col1;
    private String col2;

    public Model(String[] st){
        this.col1 = st[0];
        this.col2 = st[1];
    }
    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1;
    }

    public String getCol2() {
        return col2;
    }

    public void setCol2(String col2) {
        this.col2 = col2;
    }

}