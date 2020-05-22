for (Method method : Customer.class.getDeclaredMethods()) {
    if (method.isSynthetic()) {
        continue;
    }
    System.out.println(method.getName());
}