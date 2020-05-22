public static void main(String[] args) throws Exception {
    ScriptEngineManager sem = new ScriptEngineManager();
    ScriptEngine jsEngine = sem.getEngineByName("JavaScript");

    String expr = "artist + '-' + album + (disktotal > 1 ? ('-D' + diskno) : '')";

    jsEngine.put("artist", "U2");
    jsEngine.put("album", "The Joshua Tree");
    jsEngine.put("disktotal", 1);
    jsEngine.put("diskno", 1);
    printResult(jsEngine, "Single Disk", expr);

    jsEngine.put("artist", "Tori Amos");
    jsEngine.put("album", "To Venus and Back");
    jsEngine.put("disktotal", 2);
    jsEngine.put("diskno", 2);
    printResult(jsEngine, "Muti-Disk", expr);
}