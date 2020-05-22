public Set<Method> findTableColumsGetters(Class<TestTableData> clazz) {
    Set<Method> methods = new TreeSet<>(new Comparator<Method>() {
        @Override
        public int compare(Method o1, Method o2) {
            return Integer.valueOf(o1.getAnnotation(TableColumn.class).order())
                    .compareTo(o2.getAnnotation(TableColumn.class).order());
        }
    });
    for(Method method : clazz.getMethods()) {
        if(method.isAnnotationPresent(TableColumn.class)) {
            methods.add(method);
        }
    }
    return methods;
}