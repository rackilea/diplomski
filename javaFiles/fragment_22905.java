//ScriptGroovyParent.groovy
abstract class ScriptGroovyParent extends Script{
    def queryThisBaby(name) {
        return name +" was run."
    }
}


//Script Scccc.groovy
import org.codehaus.groovy.control.CompilerConfiguration

def configuration = new CompilerConfiguration()
configuration.setScriptBaseClass("ScriptGroovyParent")

def shell = new GroovyShell(this.class.classLoader, new Binding(), configuration)

assert shell.evaluate("queryThisBaby('My Query')") == 'My Query was run.'