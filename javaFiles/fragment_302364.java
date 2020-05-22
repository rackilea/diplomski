public class ClientService extends Service {

    //Facebook object to operate from service
    private Facebook facebook;

...

    private final ClientBinder clientBinter = new ClientBinder();

    /** Binder to service */
    public class ClientBinder extends Binder {

        public ClientService getService() {
            return ClientService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return clientBinter;
    }

    public void setFacebook(Facebook f) {
        ClientService.this.facebook = f;
    }

    public boolean loggedFacebook() {
        if (facebook == null)
            return false;
        return facebook.isSessionValid();
    }
    ...

}