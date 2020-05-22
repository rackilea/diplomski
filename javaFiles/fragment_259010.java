@ManagedBean
@ViewScoped
public class ViewBean {

    private Integer id;

    @PostConstruct
    public void init() {
        id = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));       
    }
}