import org.apache.commons.lang.StringEscapeUtils;

@Test
public void testUnescapeJava() {
    String sJava="\\u0048\\u0065\\u006C\\u006C\\u006F";
    System.out.println("StringEscapeUtils.unescapeJava(sJava):\n" + StringEscapeUtils.unescapeJava(sJava));
}


 output:
 StringEscapeUtils.unescapeJava(sJava):
 Hello