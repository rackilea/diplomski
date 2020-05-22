import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

@XmlDiscriminatorValue("sedan")
class Sedan extends Car {

    private String sedanProperty;

    public String getSedanProperty() {
        return sedanProperty;
    }

    public void setSedanProperty(String sedanProperty) {
        this.sedanProperty = sedanProperty;
    }

}