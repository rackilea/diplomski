@Named
@SessionScoped
public class KnobView implements Serializable {

    int value1;
    int value2;
    int maxval = 100;
    // getter & setter

    public void onChange1() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "val1: " + value1 + " " +
                        "val2: " + value2,
                null));
        this.value2 = maxval - value1;
    }

    public void onChange2() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "val1: " + value1 + " " +
                        "val2: " + value2,
                null));
        this.value1 = maxval - value2;
    }

}