<project name="verbose_compile" default="compile" basedir=".">
  ...
  <target name="compile">
      <javac srcdir="${src.dir}" 
         destdir="${build.dir}"
         executable="${java8.home}/bin/javac" 
         classpath="..."
         fork="true" 
         verbose="true" />
  </target>
</project>