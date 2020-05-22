task generateTheSourceFiles {
    doLast {
        generatedSrcDir.exists() || generatedSrcDir.mkdirs()
        ant.taskdef(name: 'generateJavaCode', classname: 'com.company.container.ant.GeneratorTask', classpath: configurations.generateJavaCode.asPath, loaderref: 'classes')
        ant.taskdef(name: 'attributeCompiler', classname: 'org.apache.commons.attributes.compiler.AttributeCompiler',
                classpath: configurations.attributeCompiler.asPath, loaderref: 'classes')
        ant.generateJavaCode(toDir: generatedSrcDir, metaDestDir: 'build/classes', configFile: 'src/main/resources/container/local_services.xml') {
            fileset(dir: 'src/main/java', includes: 'com/**/container/**/*Impl.java', excludes: 'com/company/web/container/*Impl.java')
        }
        ant.attributeCompiler(destDir: generatedSrcDir) {
            fileset(dir: 'src/main/java', includes: 'com/**/container/**/*.java')
        }
    }
}