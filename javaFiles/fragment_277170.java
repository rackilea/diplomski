<target name="runUnittests" depends="unitTestCompile">
  <property name="ABC_HOME" value="${base.dir}"/>
  <testng fork="yes" delegatecommandsystemproperties="true" classpathref="unitTest.classpath"
    outputDir="${testng.report.dir}" workingDir="${unitTest.src.dir}" haltOnfailure="true">
    <env key="property" value="${BLUEOPTIMA_HOME}"/>
    <xmlfileset dir="${unitTest.suites.dir}" includes="testng.xml"/>
  </testng>
</target>