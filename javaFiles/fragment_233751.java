package so.question14163260;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

@ManagedBean(name = "licenseCodes")
@SessionScoped
public class LicenseCodes {

    private SelectItem[] licenses;

    public LicenseCodes() {
        System.out.println("================Inside===============");
    }

    @PostConstruct
    public void init() {
        SelectItem[] licenses = new SelectItem[License.values().length];
        int i = 0;
        for (License l : License.values()) {
            licenses[i++] = new SelectItem(l, l.name());
        }

        setLicenses(licenses);
    }

    public SelectItem[] getLicenses() {
        return licenses;
    }

    public void setLicenses(SelectItem[] licenses) {
        this.licenses = licenses;
    }
}