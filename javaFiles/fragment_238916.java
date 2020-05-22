@ManagedBean
@RequestScoped
public class TimeBean{
    public Date getTime(){
        return new Date();
    }
}