public class Row {

    private Integer col1;
    private Integer col2;
    private Integer col3;
    private Integer Col4;
    private Integer Col5;

    public Row(Integer col1, Integer col2, Integer col3) {
        this.col1 = col1;
        this.col2 = col2;
        this.col3 = col3;
    }

    //gets sets

    public Integer getCol1() {
        return col1;
    }

    public Integer getCol2() {
        return col2;
    }

    public Integer getCol3() {
        return col3;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Row))
            return false;

        if (this == o)
            return true;

        Row other = (Row)o;
        if (col1.equals(other.getCol1()) && col2.equals(other.getCol2()) && col3.equals(other.getCol3())) {
            return true;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return col1+col2+col3;
    }
}