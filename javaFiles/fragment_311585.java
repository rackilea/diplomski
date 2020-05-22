package com.example.demo;

import java.io.File;
import java.io.IOException;
import javax.tools.*;
import java.net.URI;
import java.util.Arrays;
import java.util.Collections;

public class Compiler {
    public static void compileTestClass() throws IOException {
        Compiler.compile("com.example.TestClass", "package com.example;\n" +
                "\n" +
                "import com.google.common.collect.ImmutableMap;\n" +
                "\n" +
                "public class TestClass {\n" +
                "}\n", new File("/tmp"));
    }
    public static void compile(String className, String javaSource, File outputDir) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

        outputDir.mkdirs();
        fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Collections.singleton(outputDir));
        fileManager.setLocation(StandardLocation.CLASS_PATH, System.getProperty("user.home") + "/.m2/repository/com/google/guava/guava/19.0/guava-19.0.jar");

        JavaSourceFromString javaSourceFromString = new JavaSourceFromString(className, javaSource);
        Iterable<? extends JavaFileObject> compilationUnits = Collections.singletonList(javaSourceFromString);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, options, null, compilationUnits);
        boolean success = task.call();
        if (!success) {
            throw new RuntimeException("Compilation failed.");
        }
    }
}

/**
 * A file object used to represent source coming from a string.
 */
class JavaSourceFromString extends SimpleJavaFileObject {
    /**
     * The source code of this "file".
     */
    final String code;

    /**
     * Constructs a new JavaSourceFromString.
     *
     * @param name the name of the compilation unit represented by this file object
     * @param code the source code for the compilation unit represented by this file object
     */
    JavaSourceFromString(String name, String code) {
        super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension),
                Kind.SOURCE);
        this.code = code;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return code;
    }
}