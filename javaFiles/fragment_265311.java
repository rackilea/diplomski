@Test
public void findTableColumsGetters() {
    Set<Method> getters = findTableColumsGetters(TestTableData.class);
    for(Method getter : getters) {
        TableColumn annotation = getter.getAnnotation(TableColumn.class);
        System.out.printf("%d %s (%s)%n", annotation.order(), annotation.label(), getter.getName());
    }
}