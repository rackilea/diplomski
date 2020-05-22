Model model = ... ;

Callback<Class<?>, Object> controllerFactory = type -> {

    try {

        for (Constructor<?> c : type.getConstructors()) {
            if (c.getParameterCount() == 1 && c.getParameterTypes()[0] == BookingModel.class) {
                return c.newInstance(model);
            }
        }

        // no appropriate constructor: just use default:
        return type.newInstance(); 

    } catch (Exception exc) {
        throw new RuntimeException(exc);
    }

};

FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/fxml"));
loader.setControllerFactory(controllerFactory);
Parent view = loader.load();