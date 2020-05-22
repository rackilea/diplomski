public static Car createCar(Class model, int mileage) {
    try {
        Object o = Class.forName(model.getName())
                .getConstructor(int.class)
                .newInstance(mileage);
    } catch (InstantiationException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return (Car)o;
}