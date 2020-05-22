<path id="classpathunjar">
        <fileset dir="${lib.dir}" includes="*.jar" excludes="sqljdbc4.jar"/>
    </path>


    <target name="compile" depends="clean">
        ...
        <unjar dest="${build.dir}">
            <path refid="classpathunjar" />
        </unjar>
        ...
   </target>