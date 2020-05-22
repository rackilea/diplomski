@Test
@FileParameters(
        value = "/test.csv",
        mapper = XxxToNullMapper.class
)
public void xxxIsNullFileParameters(String a, String b) {
    System.out.println("Params are: " + a + " (is null? " + (a == null) + "), " + b + " (is null? " + (b == null) + ")");
}