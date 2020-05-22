public class TestStringTokenizer {
    private final static String INTERNAL_DELIMETER = "#,#";
    private final static String EXTERNAL_DELIMETER = "#|#";
    public static void main(String[]aregs){
        String test= "1#,#Jon#,#176#|#2#,#Jack#,#200#|#3#,#Jimmy#,#160";
        for (String s : test.split("#\\|#"))
            System.out.println(s);
        }
    }
}