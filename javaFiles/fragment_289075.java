<project name="${project.title}" basedir="./" default="all">

    <property file="build.properties" />

    <property name="path.utilities" value="${path.deploy}/utilities" />
    <property name="path.classes" value="${path.deploy}/classes" />
    <property name="path.src" value="../src" />

    <path id="compile.classpath">
        <pathelement path="${path.utilities}" />
        <pathelement path="${path.classes}" />
        <pathelement path="${classpath}" />
    </path>

    <target name="compile">
        <javac target="1.5" source="1.5" srcdir="${path.src}" destdir="${path.classes}">
            <classpath refid="compile.classpath" />
        </javac>
    </target>

</project>