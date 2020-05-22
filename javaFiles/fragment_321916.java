public void User implements HttpSessionBindingListener {

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        new File(somePath).delete();
    }

    // ...
}