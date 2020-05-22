public static void main(String[] args) {
    GroovyScriptEngine gse = new GroovyScriptEngine(new String[] {"/home/user/tmp"});
    Binding varSet = new Binding();
    varSet.setVariable("testVar", "Hello World");
    varSet.setVariable("args", null); //null, empty string, whatever evaluates to false in groovy
    gse.run("printHello.groovy", varSet);
}