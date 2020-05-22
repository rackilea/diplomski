public static CarChecker newFrom(String carName, String carReg, String className) {
    Class<?> theClass = Class.forName(className);
    Constructor<?> cons = theClass.getConstructor(String.class,String.class);
    CarChecker carChecker = cons.newInstance(new Object[] {carName, carReg });
    return carChecker;
}