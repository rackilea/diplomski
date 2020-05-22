<classpath>
      <pathelement path="${classpath}"/>
      <fileset dir="lib">
        <include name="**/*.jar"/>
      </fileset>
      <pathelement location="classes"/>
      <dirset dir="${build.dir}">
        <include name="apps/**/classes"/>
        <exclude name="apps/**/*Test*"/>
      </dirset>
      <filelist refid="third-party_jars"/>
</classpath>