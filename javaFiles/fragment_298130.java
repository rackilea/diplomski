import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import play.data.validation.Constraints;

@Entity
@DiscriminatorValue("staff")
public class Staff extends User {

    @Constraints.Required
    private Boolean isKitchenStaff;

    public static Finder<String, Staff> find = new Finder<String, Staff>(Staff.class);

    public Staff() {}
}