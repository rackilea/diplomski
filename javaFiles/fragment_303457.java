<target name="jar" depends="compile">
    <mkdir dir="${jar.dir}"/>
    <jar destfile="${jar.dir}/${ant.project.name}.jar" basedir="${classes.dir}" filesetmanifest="mergewithoutmain">
        <manifest>
            <attribute name="Main-Class" value="${main-class}"/>
            <attribute name="Class-Path" value="."/>
        </manifest>
        <zipfileset excludes="META-INF/*.SF" src="I:/Study/Codes/_JDeveloper/LoggingTestApp/Client/lib/log4j1.2.13.jar"/>
    </jar>
</target>