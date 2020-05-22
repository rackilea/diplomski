import javax.script.ScriptEngine;
import com.caucho.quercus.script.QuercusScriptEngineFactory;

QuercusScriptEngineFactory factory = new QuercusScriptEngineFactory();
ScriptEngine engine = factory.getScriptEngine();

String code = "<?php $foo = strlen('abc'); print $foo; return 'yikes'; ?>";
Object o = engine.eval(code);
System.out.println(o);