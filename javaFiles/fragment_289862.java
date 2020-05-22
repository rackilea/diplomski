<project name="test" default="target">
    <target name="target">
        <condition property="property" value="value1" else="value2">
            <contains string="${java.version}" substring="1.7"/>
        </condition>
        <echo>Java version: ${java.version}. Result: ${property}</echo>
    </target>
</project>