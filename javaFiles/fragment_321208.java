import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class JRubyInstantiationTeardownTest {

    public static int i;

    @Test
    public void test() throws Exception {

        for (i = 0; i < 100; ++i) {

            URL[] urls = new URL[] {
                new URL("file:///home/pat/jruby-1.6.7/lib/jruby.jar")
            };

            final ClassLoader cl = new URLClassLoader(urls, this.getClass().getClassLoader());

            final Class<?> rubyClass = cl.loadClass("org.jruby.Ruby");
            final Method newInstance = rubyClass.getMethod("newInstance");
            final Method evalScriptlet = rubyClass.getMethod("evalScriptlet", String.class);
            final Method tearDown = rubyClass.getMethod("tearDown");

            // "Direct" API
            Callable<Void> direct = new Callable<Void>() {
                public Void call() throws Exception {
                    // created inside thread because initialization happens immediately
                    final Object ruby = newInstance.invoke(null);

                    System.out.println("" + i + ": " + ruby);
                    evalScriptlet.invoke(ruby, "puts 'hello, world'");
                    tearDown.invoke(ruby);
                    return null;
                }
            };

            // JRuby Embed API
            final Class<?> scriptingContainerClass = cl.loadClass("org.jruby.embed.ScriptingContainer");
            final Method terminate = scriptingContainerClass.getMethod("terminate");
            final Method runScriptlet = scriptingContainerClass.getMethod("runScriptlet", String.class);

            // created outside thread because ruby instance not created immediately
            final Object container = scriptingContainerClass.newInstance();

            Callable<Void> embed = new Callable<Void>() {
                public Void call() throws Exception {

                    System.out.println(i + ": " + container);
                    runScriptlet.invoke(container, "puts 'hello, world'");
                    terminate.invoke(container);
                    return null;
                }
            };

            // separate thread for each loop iteration so its ThreadLocal vars are discarded
            final ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(direct).get();
            executor.submit(embed).get();
            executor.shutdown();
        }
    }

}