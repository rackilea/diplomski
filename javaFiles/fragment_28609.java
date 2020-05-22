<target name="jar" depends="compile">
    <mkdir dir="${jar.dir}" />

    <manifestclasspath property="jar-classpath" jarfile="${jar.dir}/${ant.project.name}.jar">
      <classpath refid="classpath" />
    </manifestclasspath>

    <jar destfile="${jar.dir}/${ant.project.name}.jar" basedir="${classes.dir}" includes="*.class">
        <manifest>
            <attribute name="Main-Class" value="${main-class}" />
            <attribute name="Class-Path" value="${jar-classpath}" />
        </manifest>
    </jar>
</target>