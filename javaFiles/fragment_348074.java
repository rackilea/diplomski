<target name="dist">
    <mkdir dir="${classes}/lib"/>
    <copy flatten="true" todir="${classes}/lib" includeemptydirs="false">
        <fileset dir="lib">
            <include name="**/*.jar" />
        </fileset>
    </copy>
    <jar destfile="${dist}/MyOneBigJar.jar">
        <fileset dir="${classes}"/>
    </jar>
  </target>