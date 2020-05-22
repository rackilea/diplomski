import groovy.ui.Console
import java.awt.event.WindowAdapter

class TestGroovyConsole{
    static main(args){
        int x = 5
        Console console = new Console()
        console.setVariable("x",x) // to make x available in console
        console.run() // to launch console
        console.frame.addWindowListener([windowClosing: { e -> println "Console closing" }] as WindowAdapter)
    }
}