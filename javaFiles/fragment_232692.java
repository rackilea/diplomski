<target name="native2ascii">
  <delete dir="${classes.dir}/resources" includes="*.properties" />
  <native2ascii encoding="cp1256" src="${source.dir}/resources" dest="${classes.dir}/resources" includes="*.properties" />
  <copy todir="${exploaded.dir}/WEB-INF/classes/resources">
    <fileset dir="${classes.dir}/resources" includes="*.properties" />
  </copy>
</target>