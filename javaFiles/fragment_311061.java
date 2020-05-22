<path id="jre.classpath">
  <pathelement location="${java.home}\lib" />
</path>
// Add paths for build.classpath and define {src},{target} as usual
<target name="compile" depends="copy-resources">
  <mkdir dir="${target}/classes"/>
  <javac bootclasspathref="jre.classpath" includejavaruntime="yes" debug="on" srcdir="${src}" destdir="${target}/classes" includes="**/*">
    <classpath refid="build.classpath"/>
  </javac>
</target>