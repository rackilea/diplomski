<target name="runtest"
        description="Runs the test you specify on the command line with -Dtest="
        depends="compile, ensure-test-name">
    <junit printsummary="withOutAndErr" fork="yes">
        <sysproperty key="tests" value="${tests}" />
        <classpath refid="classpath" />
        <formatter type="plain" usefile="false" />
        <batchtest>
            <fileset dir="${src}">
                <include name="**/${test}.java" />
            </fileset>
        </batchtest>
    </junit>
</target>