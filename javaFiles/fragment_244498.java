<project name="testant" default="main">
    <property name="local.builds.dir" value="C:/scratch/${ant.project.name}"/>

    <target name="main">
        <echo>local.builds.dir = ${local.builds.dir}</echo>

        <path id="classpath.test">
            <pathelement location="${local.builds.dir}"/>
        </path>

        <property name="d" refid="classpath.test"/>
        <echo>classpath.test = ${d}</echo>
    </target>
</project>