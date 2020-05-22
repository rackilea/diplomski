public class bean implements Serializable {
    //all variabile and methode
    public void checkboxChanged() {
        try {
            FacesContext.getCurrentInstance()
                .getExternalContext().redirect("./page.jsf");
        }
        catch (IOException e) {
            //error
        }
    }
}