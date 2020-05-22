import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MyClass implements Serializable {

    public MyClass() {
        try {
            ...
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage( "messages1", 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
        }