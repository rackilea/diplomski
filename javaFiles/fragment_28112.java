public aspect HackTheHack {

    declare precedence: "HackTheHack", "Hack";

    pointcut authHack(String user, String pass): call(* Authenticator.authenticate(String,String)) && args(user,pass);

    boolean around(String user, String pass): authHack(user,pass) {
        boolean status = false;
        try {
            Class<?> klass = Class.forName("Authenticator");
            Object newInstance = klass.newInstance();
            Method authMethod = klass.getDeclaredMethod("authenticate", String.class, String.class);
            status = (Boolean) authMethod.invoke(newInstance, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return status;
    }
}