<!-- Compile application -->
  <target name="compile">
    <mkdir dir="${classes.dir}"/>
    <javac srcdir="${src.dir}" destdir="${classes.dir}" debug="yes" includeantruntime="false">
      <classpath refid="classpath" />
    </javac>
  </target>