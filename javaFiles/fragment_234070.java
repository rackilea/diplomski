<target>
 <delete dir="${dest.dir}" failonerror="false" /> 
      <mkdir dir="${dest.dir}" />
  <war destfile="${package.file}" webxml="${temp.dir.web-inf}/web.xml" basedir="${temp.dir}">
    <fileset dir="${pages.dir}"/>
    <lib dir="${lib.dir}">
        <exclude name="servlet-api.jar"/>
        <include name="de.vogella.build.test.ant.jar"/>
    </lib>
    <classes dir="${temp.dir.classes}" />
  </war>
</target>