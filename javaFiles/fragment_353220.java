@Entity
@SecondaryTable("PARENT_TABLE")
public class Child extends AbstractParent {

    private String childField;

    public String getChildProperty() {
        return childField;
    }

}