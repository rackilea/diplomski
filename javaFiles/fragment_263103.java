<target name="compile" depends="prepare">    
     <javac destdir="${build.dir}">
        <src location="${src.dir}" />
        <src location="${apt_generated.dir}" />
        <classpath refid="project.classpath" />
     </javac>   
 </target>