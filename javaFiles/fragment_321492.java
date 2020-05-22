<target name="run" depends="jar">
  <java fork="true" classname="${main.class}">
    <classpath>
      <path refid="classpath"/>
      <path location="${bin.dir}/omsimulation-${version}.jar"/>
    </classpath>
  </java>
</target>