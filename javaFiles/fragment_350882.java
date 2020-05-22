<target name="tests" depends="build">
        <mkdir dir="${junit.output.dir}"/>
        <junit fork="yes" printsummary="withOutAndErr" showoutput="true" outputtoformatters="true" haltonfailure="no"
               failureproperty="test.failed">
            <formatter type="xml"/>
            <test name="com.tests.ExampleTests" todir="${junit.output.dir}"/>
            <classpath refid="seleniumproject.classpath"/>
        </junit>
        <fail message="Test failure detected, check test results." if="test.failed"/>
 </target>

 <target name="junitreport">
    <junitreport todir="${junit.output.dir}">
        <fileset dir="${junit.output.dir}">
            <include name="TEST-*.xml"/>
        </fileset>
        <report format="frames" todir="${junit.output.dir}"/>
    </junitreport>
 </target>