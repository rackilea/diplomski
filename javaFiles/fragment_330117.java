// factory for controllers also allowing to load fxmls and unregistering listeners
public class Factory implements Callback<Class<?>, Object> {

    public Factory(List<InvalidationListener> listeners) {
        this.listeners = listeners;
    }

    private final List<InvalidationListener> listeners;

    @Override
    public Object call(Class<?> param) {
        Object result = null;
        try {
            result = param.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Could not create instance of "+param.getName(), ex);
        }

        if (result instanceof ShutdownObserver) {
            InvalidationListener listener = ((ShutdownObserver) result).getObserver();
            if (listener != null) {
                listeners.add(listener);
            }
        }

        if (result instanceof FactoryAccessController) {
            ((FactoryAccessController) result).setFactory(this);
        }

        return result;
    }

    public void removeShutdownListener(InvalidationListener listener) {
        listeners.remove(listener);
    }

    public <T> T loadFXML(URL url) throws IOException {
        if (url == null) {
            throw new IllegalArgumentException();
        }
        FXMLLoader loader = new FXMLLoader(url);
        loader.setControllerFactory(this);
        return loader.load();
    }

}