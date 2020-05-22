<target name="-post-jar">
    <jar jarfile="${dist.jar}" update="true">
        <zipfileset src="${dist.jar}" includes="**/*.class" />
        <zipfileset src="${libs.somelibrary.classpath}" includes="**/*.class"/>
    </jar>
</target>