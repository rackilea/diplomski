<path id="build-classpath">
    <fileset dir="${dist}/lib">
        <include name="*.jar"/>
    </fileset>
</path>
<manifestclasspath property="lib.list" jarfile="${dist}/lib/myprog.jar">
    <classpath refid="build-classpath"/>
</manifestclasspath>
<jar jarfile="${dist}/lib/myprog.jar"
     basedir="${build}"
     includes="com/my/prog/**" >
    <manifest>
        <attribute name="Main-Class" value="com.my.prog.MyProg"/>
        <attribute name="Class-Path" value="${lib.list}"/>
    </manifest>
</jar>