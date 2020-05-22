public void showMethods(Object obj) {
    if (obj != null) {
        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}