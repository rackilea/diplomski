package application;

import java.lang.reflect.Constructor;

import javafx.util.Callback;

public enum ControllerFactory implements Callback<Class<?>, Object> {

    INSTANCE ;

    private final DataModel model = new DataModel();

    @Override
    public Object call(Class<?> type) {
        try {
            for (Constructor<?> constructor : type.getConstructors()) {
                if (constructor.getParameterCount() == 1
                        && DataModel.class.isAssignableFrom(constructor.getParameterTypes()[0])) {
                    return constructor.newInstance(model);
                }
            }
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}