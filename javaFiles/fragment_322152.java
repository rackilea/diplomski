<target name="display">
    <concat destfile="java.concat">
        <fileset dir="${src}" includes="**/*.java"/>
    </concat>
    <exec executable="less">
        <arg value="java.concat" />
    </exec>
</target>