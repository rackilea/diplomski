task processWebapp(type: Copy) {
    from('src/main/webapp') {
        include "**/*"
    }
    eachFile {
        if (it.sourceName.endsWith('.js') && !it.sourceName.endsWith('.min.js')) {
            it.exclude()
            Reader reader = it.file.newReader()
            String source = ""
            try {
                source = reader.readLines().join("\r\n")
            } finally {
                reader.close()
            }

            com.google.javascript.jscomp.Compiler compiler = new com.google.javascript.jscomp.Compiler(System.err)

            CompilerOptions options = new CompilerOptions()
            CompilationLevel.SIMPLE_OPTIMIZATIONS.setOptionsForCompilationLevel(
                    options)

            SourceFile extern = SourceFile.fromCode("externs.js", "")

            SourceFile input = SourceFile.fromCode(it.sourceName, source)

            compiler.compile(extern, input, options)

            String transpiled = compiler.toSource()

            def directoryPath = it.relativePath - it.sourceName

            File theDir = new File("build/resources/main/${directoryPath}")
            if (!theDir.exists()) {
                theDir.mkdirs()
            }

            PrintWriter writer = new PrintWriter("build/resources/main/${it.relativeSourcePath}", "UTF-8")
            try {
                writer.println(transpiled)
            } finally {
                writer.close()
            }
        }
    }
    destinationDir = file('build/resources/main')
}