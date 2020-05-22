import javax.script.*;

class Ideone {
    public static void main(String[] args) throws java.lang.Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        String searchTerm = "i >= 19 && i <= 24";
        int i;
        try {
            i = 19;
            engine.put("i", i);
            while ((boolean)engine.eval(searchTerm)) {
                System.out.println("i = " + i);
                ++i;
                engine.put("i", i);
            }
            System.out.println("Done");
        } catch (ScriptException scriptException) {
            System.out.println("Failed with script error");
        }
    }
}