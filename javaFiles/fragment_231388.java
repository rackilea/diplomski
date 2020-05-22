<javadoc 
    destdir="${docs.dir}" 
    author="true" version="true" 
    use="true" 
    doctitle="Test" >
    <fileset dir="${project.dir}/src" defaultexcludes="yes">
         <include name="**/*.java"/>
         <exclude name=".externalToolBuilders/**"/>
    </fileset>
</javadoc>