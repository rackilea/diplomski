@Builder(builderMethodName = "buildFoo")
public static String foo(String param1, String param2){
    return "foo" + param1 + param2;
}

@Builder(builderMethodName = "buildBar")
public static String bar(String param1, String param2){
    return "bar" + param1 + param2;
}

@Test
public void test(){

   assertThat(buildFoo().param1("h").param2("w").build()).isEqualTo("foohw");

   assertThat(buildBar().param1("h").param2("w").build()).isEqualTo("foohw");
}