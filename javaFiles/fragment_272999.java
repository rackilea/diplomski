<target name="-post-jar">
    <property name="common.build.dir" location="${build.dir}/../../commonBuildDir"/>    
    <copy todir="${common.build.dir}" preservelastmodified="true">
            <fileset file="${dist.jar}"/>
    </copy>
</target>