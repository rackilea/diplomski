@Test
public void test() {
    String time = "07:df:01:0e:0e:28:2a:39";
    time = time.replaceFirst(":", "");
    String[] values = time.split(":");
    assertEquals(7, values.length);
    for(String value : values){
        System.out.print(Integer.parseInt(value, 16) + " ");
    }
}