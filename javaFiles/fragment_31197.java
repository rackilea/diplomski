<project basedir="." default="ajc">
    <path id="classpath">
        <pathelement path="${scope_classpath}" />
        <pathelement path="${plugin_classpath}" />
    </path>
    <taskdef
        classname="org.aspectj.tools.ant.taskdefs.AjcTask"
        name="iajc" classpathref="classpath" />
    <target name="ajc">
        <iajc
            sourceroots="${aspectj.sourcepath}"
            inpath="${aspectj.binarypath}"
            destdir="${aspectj.targetpath}"
            classpathref="classpath"
            source="1.6"
            target="1.6"
        />
        <move todir="${aspectj.binarypath}">
            <fileset dir="${aspectj.targetpath}">
                <include name="**/*.class" />
            </fileset>
        </move>
    </target>
</project>