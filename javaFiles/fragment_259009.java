@ManagedBean
@RequestScoped
public class RequestBean {

    @ManagedProperty(value="#{param.id}")
    private Integer id;

    @ManagedProperty(value="#{viewBean}")
    private ViewBean viewBean;
}