import org.codehaus.groovy.control.CompilerConfiguration

class Main {
    static void main( args ) {
        def compilerConfig = new CompilerConfiguration()
        compilerConfig.scriptBaseClass = 'MyScript'
        def shell = new GroovyShell( this.class.classLoader, compilerConfig )

        shell.evaluate( '''
    task helloWorld {
        println "Hello world"
    }
    ''' )
    }
}

abstract class MyScript extends Script {
    def task( taskObject ) {
    }
}