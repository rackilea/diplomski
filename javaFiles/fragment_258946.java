public static void main(String[] args) throws ScriptException, ParseException {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("js");
    String[] dateStrings = new String[] {
            "2015-10-14T16:41:42.000Z",
            "2015-10-14T19:01:53.100+01:00",
            "2015-10-14 05:20:29" };

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    for (String d : dateStrings) {
        String script = "new Date('" + d + "')";
        Object eval = engine.eval(script);
        Date parsed = sdf.parse(eval.toString().replace("[Date ", "").replace("]", ""));
        System.out.println(eval + " -> " + parsed);

    }

}