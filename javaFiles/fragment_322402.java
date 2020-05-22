public class Tests<T> {

    @Test
    public void test01() {
        Tests<String> stringTest= new Tests<>();
        System.out.println(stringTest.parseObject("testtestt", String.class));
    }

    public T parseObject(String parameters, Class<T> clazz) {
        Gson gson = new Gson();
        T obj = (T) gson.fromJson(parameters, clazz);
        return obj;
    }
}