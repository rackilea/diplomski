<target name="run" depends="build">
  <java classpath="${basedir}" classname="..." fork="yes">
    <jvmarg value="-enableassertions"></jvmarg>
    <arg file="abc.txt"/>
    <arg file="def.txt"/>
  </java>
</target>