public static void main(String[] args) throws Exception {
    Class<?> mainClass = Class.forName(System.getProperty("mainClass"));

    for (String className : System.getProperty("initClasses").split(";")) {
        Class.forName(className);
    }

    Method main = mainClass.getMethod("main", String[].class);
    main.invoke(null, new Object[] { args });
}