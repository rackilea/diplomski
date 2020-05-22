import groovy.ui.Console
public class TestGroovyConsole{
    public static void main(String[] args){
        int x = 5;
        Console console = new Console();
        console.setVariable("x",x);// to make x available in console
        console.run(); // to launch console
    }

}