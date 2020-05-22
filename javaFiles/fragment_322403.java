@Test
public void test02() {
    String stringstring = parseObject02("stringstring", String.class);
    System.out.println(stringstring);
    List list = parseObject02("[1,2,3]", List.class);
    System.out.println(list);
//        output in console
//        stringstring
//        [1.0, 2.0, 3.0]
}

public <T> T parseObject02(String parameters, Class<T> clazz) {
    Gson gson = new Gson();
    T obj = gson.fromJson(parameters, clazz);
    return obj;
}