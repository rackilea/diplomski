public class Test {
    public static void main(String... args) throws InvocationTargetException, IllegalAccessException {
        SetEntity se = new SetEntity();
        se.getCol().add(1);
        se.getCol().add(2);
        ListEntity le = new ListEntity();
        ConvertUtils.register(new Converter() {
            @Override
            public <T> T convert(Class<T> tClass, Object o) {
                List list = new ArrayList<>();
                Iterator it = ((Set)o).iterator();
                while (it.hasNext()) {
                    list.add(it.next());
                }
                return (T)list;
            }
        }, List.class);
        BeanUtils.copyProperties(le, se);
        System.out.println(se.getCol().toString());
        System.out.println(le.getCol().toString());
    }
}