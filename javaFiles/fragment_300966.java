package mvpc;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class MVPCLoader<M, V, P, C> {

    private P presenter ;
    private C controller ;
    private V view ;
    private M model ;

    public V load(URL resource, M model, P presenter) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException  {

        if (view != null) {
            throw new IllegalStateException("FXML can only be loaded once by a MVPCLoader instance");
        }

        this.model = model ;
        this.presenter = presenter ;

        FXMLLoader loader = new FXMLLoader(resource);
        loader.setControllerFactory(this::controllerFactory);
        view =  loader.load();
        controller = loader.getController() ;
        injectInto(presenter, model);
        injectFieldsIntoPresenter(loader, presenter);
        initializePresenterIfPossible(presenter);
        return view ;
    }

    public P getPresenter() {
        return presenter ;
    }

    public M getModel() {
        return model ;
    }

    public C getController() {
        return controller ;
    }

    private void initializePresenterIfPossible(P presenter) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        for (Method m : presenter.getClass().getDeclaredMethods()) {
            boolean wasAccessible = m.isAccessible() ;
            m.setAccessible(true);
            if ("initialize".equals(m.getName()) && m.getParameterCount() == 0) { 
                if ((m.getModifiers() & Modifier.PUBLIC) != 0 || m.getAnnotation(FXML.class) != null) {
                    m.invoke(presenter);
                }
            }
            m.setAccessible(wasAccessible);
        }
    }

    private void injectFieldsIntoPresenter(FXMLLoader loader, P presenter) throws IllegalArgumentException, IllegalAccessException  {
        Map<String, Object> namespace = loader.getNamespace() ;
        for (Field field : presenter.getClass().getDeclaredFields()) {
            boolean wasAccessible = field.isAccessible() ;
            field.setAccessible(true);
            if (field.getAnnotation(FXML.class) != null) {
                if (namespace.containsKey(field.getName())) {
                    field.set(presenter, namespace.get(field.getName()));
                }
            }
            field.setAccessible(wasAccessible);
        }
    }

    private C controllerFactory(Class<?> type) {
        try {
            @SuppressWarnings("unchecked")
            C controller = (C) type.newInstance();
            injectInto(controller, model);
            return controller ;
        } catch (Exception exc) {
            if (exc instanceof RuntimeException) throw (RuntimeException)exc ;
            throw new RuntimeException(exc);
        }
    }

    private void injectInto(Object target, Object value) throws IllegalArgumentException, IllegalAccessException  {
        for (Field field : target.getClass().getDeclaredFields()) {
            boolean wasAccessible = field.isAccessible() ;
            field.setAccessible(true);
            if (field.get(target) == null && field.getType() == value.getClass() && field.getAnnotation(FXML.class) != null) {
                field.set(target, value);
            }
            field.setAccessible(wasAccessible);
        }
    }
}