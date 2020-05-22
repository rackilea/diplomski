public static void main(String[] args) throws Exception {
    Object[] params = new Object[] {Integer.valueOf(2), "name"};
    Class<?> cls[] = new Class<?>[params.length];
    List<Class<? extends Object>> classes = 
           Arrays.asList(params).stream().map(p -> p.getClass())
                 .collect(Collectors.toList());
    for(int i = 0; i < params.length; i++) {
        cls[i] = classes.get(i);
    }
    Person.class.getConstructor(cls)
    .newInstance(params);
}