Map<Class<?>, Consumer<?>> mapping = new Map<> {{
    put(a.b.Athletic1.class, 
        o -> {
            Athletic1 a1 = (Athletic1) o;
            // do stuff
        });
    put(a.b.Athletic10.class, 
        o -> {
            Athletic10 a10 = (Athletic10) o;
            // do stuff
        });
}};

Consumer<Object> c = mapping.get(obj.getClass());
if (c != null) {
    c.accept(obj);
}