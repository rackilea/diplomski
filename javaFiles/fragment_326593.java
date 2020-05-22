@ManagedBean
@SessionScoped
public class MyManagedBean {
@EJB
private MyDAO dao;

public void action() {
....
    dao.save(o);
}