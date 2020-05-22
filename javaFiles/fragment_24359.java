class LoginDialog {

    List<LoginListener> listeners = new ArrayList<>();

    JDialog dialog;
    JButton accept;
    JButton cancel;

    public void show() {
        //create and show GUI components
    }

    public void close() {
        if(dialog != null) {
            dialog.dispose();
        }
    }

    ...

    public void addLoginListener(LoginListener loginEventListener) {
        if(!listeners.contains(loginEventListener)) {
            listeners.add(loginEventListener);
        }
    }

    public void removeLoginListener(LoginListener loginEventListener) {
        listeners.remove(loginEventListener);
    }

    public void dispatchLoginEvent(LoginEvent evt) {
        for(LoginListener loginListener: listeners) {
            loginListener.handleLoginEvent(evt);
        }
    }
}