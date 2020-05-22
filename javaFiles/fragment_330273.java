public class Test {
    public static void main(String[] args) throws Exception {
        configure(new ServiceImpl());
    }

    public static <T> void configure(Service<T> service) {
        Method[] allDeclaredMethods = service.getClass().getDeclaredMethods();

        for (Method declaredMethod : allDeclaredMethods) {
            try {
                Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
                if (parameterTypes.length == 1) {
                    Class<?> parameterType = parameterTypes[0];
                    if (Event.class.isAssignableFrom(parameterType)) {
                        ParameterizedType type = ((ParameterizedType) declaredMethod
                                .getGenericParameterTypes()[0]);
                        Type typeArgument = type.getActualTypeArguments()[0];
                        System.out.println("Parameter type: " + type.getRawType() + ", Generic type argument: " + typeArgument);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

interface Response {
}

interface Service<T> {
    public Response findObject(RequestEvent<T> event);
}

class ServiceImpl implements Service<SomeObject> {
    public Response findObject(RequestEvent<SomeObject> event) {
        return null;
    }

    public Response doSomething(DoSomethingEvent<SomethingAction> event) {
        return null;
    }
}

interface Event<T> {
}

interface SomethingAction {
}

class SomeObject {
}

class DoSomethingEvent<T> extends RequestEvent<T> {
}

interface Handle<T> {
}

class RequestEvent<T> implements Event<T> {
    Handle<T> t;

    public Handle<T> getHandle() {
        return null;
    }
}