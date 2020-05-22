Object ic = Proxy.getInvocationHandler(facade);
Field[] fields = ic.getClass().getDeclaredFields();
for (Field field : fields) {
    field.setAccessible(true);
    System.out.println(field.getName() + "=" + field.get(ic);
}