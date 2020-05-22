<target name="run" depends="jar">
    <java classname="${main-class}" fork="true" >
        <classpath>
            <path refid="classpath" />
            <path location="${jar.dir}/${ant.project.name}.jar" />
        </classpath>
    </java>
</target>