<target name="compile" depends="prepare">    
        <-- compile generated classes-->
        <javac srcdir="${apt_generated.dir}" destdir="${build.generated.dir}">
            <classpath refid="project.classpath"/>
        </javac>    

        <-- compile sources -->   
        <javac srcdir="${src.dir}" destdir="${build.dir}">
            <classpath location="${build.generated.dir}"/>
            <classpath refid="project.classpath"/>
        </javac>        
    </target>