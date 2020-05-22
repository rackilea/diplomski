private static void inspect(Runnable runnable) throws Exception {       
    for(Field f : runnable.getClass().getDeclaredFields()) {
        f.setAccessible(true);
        System.out.println("name: " + f.getName());
        Object o = f.get(runnable);
        System.out.println("value: " + o);
        System.out.println("class: " + o.getClass());
        System.out.println();
    }
}