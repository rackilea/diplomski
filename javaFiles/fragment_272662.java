<target name="jar" depends="compile">
    <jar destfile="${jar-dir}/${ant.project.name}.jar" basedir="${classes-dir}">
        <manifest>
            <attribute name="Main-Class" value="${main-class}"/>
        </manifest>
        <zipgroupfileset dir="${lib-dir}" includes="*.jar"/>
    </jar>
</target>