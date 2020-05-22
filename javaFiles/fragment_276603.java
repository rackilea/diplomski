import org.codehaus.groovy.jsr223.GroovyScriptEngineImpl

import javax.script.ScriptContext
import javax.script.SimpleBindings
import javax.script.SimpleScriptContext
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

class GroovyScriptEngineExample {

    static void main(args) {
        def script1 = '''
def x = 4
y++
x++
'''

        def script2 = '''
def y = 10
x += y
'''

        final GroovyScriptEngineImpl engine = new GroovyScriptEngineImpl()
        final ExecutorService executorService = Executors.newFixedThreadPool(5)

        (0..3).each {
            List<Future> tasks = []

            final SimpleBindings bindings = new SimpleBindings(new ConcurrentHashMap<String, Object>())
            bindings.put('x', 1)
            bindings.put('y', 1)

            (0..<5).each {
                tasks << executorService.submit {
                    engine.setClassLoader(new GroovyClassLoader())
                    engine.eval(script1, bindings)
                }
                tasks << executorService.submit {
                    println engine.getClassLoader()
                    engine.eval(script2, bindings)
                }
            }

            tasks*.get()

            println bindings.entrySet()
        }

        executorService.shutdown()
    }
}