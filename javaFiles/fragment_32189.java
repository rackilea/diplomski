<target name="jar.noCompile.src">  
    <jar destfile="${ant.project.name}.jar">  
      <fileset dir="${build}"/>  
      <fileset dir="${src}" includes="**/*.java"/>  
    </jar>  
</target>