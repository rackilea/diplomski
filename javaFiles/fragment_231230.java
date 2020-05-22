<target name="compile" depends="init">
    <javac srcdir="${src}" destdir="${build}" debug="on" includeantruntime="false">
        <classpath refid="dep.runtime" />
    </javac>

    <property name="myclasspath" refid="dep.runtime"/>

    <exec dir="." executable="../../scripts/genClasspath.pl" os="Linux">
        <arg value=".classpath"/>
        <arg value="${myclasspath}"/>
    </exec>

</target>