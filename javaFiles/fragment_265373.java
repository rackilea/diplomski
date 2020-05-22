import org.codehaus.groovy.control.customizers.builder.CompilerCustomizationBuilder
import org.codehaus.groovy.control.CompilerConfiguration
import groovy.transform.CompileStatic

//your base Script class that declares only valid members
//for example `log`
abstract class MyScript extends groovy.lang.Script{
    PrintStream log
}

//create compiler config with base script class 
CompilerConfiguration cc = new CompilerConfiguration()
cc.setScriptBaseClass(MyScript.class.getName())
//make static compilation set for class loader
cc = CompilerCustomizationBuilder.withConfig(cc){ 
    ast(CompileStatic) 
}
//create classloader with compile config
GroovyClassLoader gcl = new GroovyClassLoader(this.getClass().getClassLoader(),cc)


GroovyCodeSource src = new GroovyCodeSource(
    "log.println 'hello world'",
    "Foo.groovy",
    GroovyShell.DEFAULT_CODE_BASE
)
def c = gcl.parseClass(src, true)  //this will fail for 'blah blah blah' source
def i = c.newInstance(log:System.out)
i.run()