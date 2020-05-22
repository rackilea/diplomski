CachedCompiler cc = CompilerUtils.CACHED_COMPILER;

    String text = "generated test " + new Date();
    Class compiled = cc.loadFromJava(EG_FOO_BAR_TEE, "package eg;\n" +
            '\n' +
            "import eg.components.BarImpl;\n" +
            "import eg.components.TeeImpl;\n" +
            "import eg.components.Foo;\n" +
            '\n' +
            "public class FooBarTee{\n" +
            // more source code deleted.