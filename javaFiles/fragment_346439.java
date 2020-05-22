<target name="main-compile">
    <javac includeantruntime="false" 
           srcdir="src/main/java"
           destdir="${gen.bin.main.dir}" 
           debug="on"
           includes="com/myapp/api/**/*.java, com/myapp/impl/core/FizzImpl/**/*.java">
        <classpath refid="lib.main.path"/>
    </javac>
</target>