@Entity
public class MyEntity {

    @PostLoad
    protected void repair(){
        if(myStringProperty!=null)myStringProperty=myStringProperty.trim();
    }

    private String myStringProperty;
    public String getMyStringProperty() {
        return myStringProperty;
    }
    public void setMyStringProperty(String myStringProperty) {
        this.myStringProperty = myStringProperty;
    }

}