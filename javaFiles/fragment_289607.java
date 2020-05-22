public static void main(String[] args)  {
    final String pattern = "%NAME% - %JOB% ### %AMOUNT%";
    final String text = "Peter Miller - Product Management ### 20000";

    for (final Entry<String, String> e : match(pattern, text).entrySet()) {
        System.out.println(e.getKey()+"\t"+e.getValue());
    }
}