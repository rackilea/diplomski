<target name="run" depends="jar">
        <java fork="true" classname="${main-class}">
            <classpath>
             <path location="${jar.dir}/${ant.project.name}.jar"/>
            </classpath>
            <arg value="${arg0}" />
        <arg value="${arg1}" />
        </java>
    </target>