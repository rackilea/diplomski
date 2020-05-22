<target name="run-unit-tests" >
    <run-tests location="${module1.location}" />
    <run-tests location="${module2.location}" />
</target>

<!-- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -->
<!-- Writes the results of the unit tests in a junit report        -->
<!-- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -->
<target name="unit-tests" depends="run-unit-tests">
    <junitreport todir="${junit.report.dir}" tofile="TEST-UnitTestSuites.xml">
        <fileset dir="${junit.output.dir}">
            <include name="**/TEST-*.xml" />
        </fileset>
    </junitreport>
    <fail if="${testsFailed2}" message="Some of the unit tests failed." />
</target>

<macrodef name="run-tests">
    <attribute name="location" />
    <sequential>
        <trycatch>
            <try>
                <echo message="@{location}" />
                <if>
                    <available file="@{location}/build.xml" />
                    <then>
                        <ant antfile="@{location}/build.xml" inheritAll="false" target="${junit-target}" />
                    </then>
                </if>
            </try>
            <catch>
                <property name="testsFailed2" value="true" />
            </catch>
        </trycatch>
    </sequential>
</macrodef>