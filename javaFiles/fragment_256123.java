<project name="test" default="clean">

    <dirname property="build.dir" file="${ant.file.test}" />

    <target name="clean">
        <delete>
            <fileset dir="${build.dir}/test">
                <include name="**/*,*.xml" />
            </fileset>
        </delete>
    </target>

</project>