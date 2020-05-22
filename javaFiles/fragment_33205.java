<target description="copy Eclipse compiler jars to ant lib directory" name="init-eclipse-compiler">
    <copy todir="${ant.library.dir}">
        <fileset dir="${ECLIPSE_HOME}/plugins" includes="org.eclipse.jdt.core_*.jar"/>
    </copy>
    <unzip dest="${ant.library.dir}">
        <patternset includes="jdtCompilerAdapter.jar"/>
        <fileset dir="${ECLIPSE_HOME}/plugins" includes="org.eclipse.jdt.core_*.jar"/>
    </unzip>
</target>