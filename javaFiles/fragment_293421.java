<target name="run" depends="jar">
    <java fork="true" classname="${main-class}">
        <classpath>
            <path refid="classpath"/>
            <path location="${jar.dir}/${ant.project.name}.jar"/>
        </classpath>
    </java>
</target>