@Singleton
public class UpdateSubscriptions {

    @Schedule(hour="*/6", minute="0", second="0", persistent=false)
    public void run() {
        // Do your job here.
    }

}