<target name="dist" depends="compile" description="Generates distributable">
    <!-- creates the distribution directory -->
    <mkdir dir="${dist}/lib" />

    <!-- Remove manifest. This jar will end up on the classpath of CC.jar -->
    <jar jarfile="${dist}/lib/CC-${DSTAMP}.jar" basedir="${build}"/>

    <!-- Fancy task that takes the pain out creating properly formatted manifest value -->
    <manifestclasspath property="mf.classpath" jarfile="${dist}/lib/CC.jar">
        <classpath>
            <fileset dir="${dist}/lib" includes="*.jar"/>
        </classpath><!--end tag-->
    </manifestclasspath>

    <!-- This is the executable jar -->
    <jar jarfile="${dist}/lib/CC.jar" basedir="${build}">
        <manifest>
            <attribute name="Main-Class" value="jab.jm.main.Test"/>
            <attribute name="Class-Path" value="${mf.classpath}"/> 
        </manifest>
    </jar>

</target>