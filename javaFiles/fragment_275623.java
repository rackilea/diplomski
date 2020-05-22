/** Service class */
@Stateless
public class Service {

    @EJB
    Callback callback;

    public void upload() {
        callback.call();
    }

}