@Component
public class FacesComponent implements Serializable {

    public Locale getLocaleFromFrontend() {
        return FacesContext.getCurrentInstance().getViewRoot().getLocale();
    }
}