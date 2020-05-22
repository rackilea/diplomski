public class ComplexObject {
    private String description1;
    private String description2;
    private Double value;

    public ComplexObject(String description1, String description2, Double value) {
        this.description1 = description1;
        this.description2 = description2;
        this.value = value;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getDescription2() {
        return description2;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }
}