<!-- depends="jar" have to stay:
    without it, we haven't the variable ${application.title} -->
<target name="MY-EXPORT-SOURCES" depends="jar">
    <echo>MY TARGET: PACKAGING ${application.title} SOURCES</echo>
    <delete file="dist/${application.title}.SOURCES.zip"/>
    <zip destfile="dist/${application.title}.SOURCES.zip" basedir="src"
        includes="**/*.java"/>
</target>