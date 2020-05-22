@ManagedBean
@ViewScoped
public class EFindUser implements Serializable{
    private static final long serialVersionUID = -7106162864352727534L;
    private boolean responseRendered = false;

    public EFindUser() {
    }

    public void findUser() {
        responseRendered = !responseRendered;
        System.out.println("finding..... ("+ responseRendered+")" + this);
    }
    public boolean isResponseRendered() {
        return responseRendered;
    }

    public void setResponseRendered(boolean responseRendered) {
        this.responseRendered = responseRendered;
    }       
}