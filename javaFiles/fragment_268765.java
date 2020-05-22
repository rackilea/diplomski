<cobertura-instrument todir="${instrumented.dir}">
  <ignore regex="org.apache.log4j.*" />
  <fileset dir="${classes.dir}">
    <include name="**/*.class" />
    <exclude name="**/*Test.class" />
  </fileset>
  <fileset dir="${jars.dir}">
    <include name="my-simple-plugin.jar" />
  </fileset>
</cobertura-instrument>