public class Player implements HttpSessionBindingListener {

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        // Add player to list.
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        // Remove player from list.
    }

    // ...

}