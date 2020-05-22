<path id="compile.cliClasspath">
    <fileset dir="${cliLibDir}">
        <include name="*.jar" />
    </fileset>
    <fileset dir="${cliTomcatlib}">
        <include name="servlet-api.jar" />
        <include name="jsp-api.jar" />
        <include name="el-api.jar" />
    </fileset>
</path>