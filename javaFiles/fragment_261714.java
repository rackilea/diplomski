import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class SensitivityDto extends AuditableEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private long sensitivityId;


    private boolean isSelected = true;

    public SensitivityDto() {
    }

    /** other getter/setters */
    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

}