<target name="build" depends="test" description="Create executable jar archive">
    <ivy:retrieve pattern="${dist.dir}/lib/[artifact]-[revision](-[classifier]).[ext]"/>

    <manifestclasspath property="jar.classpath" jarfile="${jar.file}">
        <classpath>
            <fileset dir="${dist.dir}/lib" includes="*.jar"/>
        </classpath>
    </manifestclasspath>

    <jar destfile="${jar.file}" basedir="${build.dir}/classes">
        <manifest>
            <attribute name="Main-Class" value="${jar.main.class}" />
            <attribute name="Class-Path" value="${jar.classpath}" />
        </manifest>
    </jar>
</target>