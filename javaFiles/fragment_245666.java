<project name="EtlAutomation" default="compile" basedir=".">
    <property name="src" value="${basedir}"/>
    <path id="compile.classpath">
        <fileset dir="./">
            <include name="*.jar"/>
        </fileset>
    </path>
    <target name="compile" >
        <javac destdir="${src}" srcdir="${src}">
            <classpath refid="compile.classpath"/>
        </javac>
    </target>
    <target name="run" depends="compile">
        <junit>
           <classpath refid="compile.classpath" />
               <test name="TestExample" />
        </junit>
    </target>
</project>