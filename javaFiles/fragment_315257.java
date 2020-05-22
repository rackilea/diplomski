<target name="create-funky-jar" depends="some-other-funky-targets">
    <javac
      srcdir="${src.dir}"
      includes="**/reports/*.java"
      destdir="${build.classes.dir}"
      deprecation="${javac.deprecation}"
      source="${javac.source}"
      target="${javac.target}"
      includeantruntime="false">
      <classpath>
        <path path="${javac.classpath}:${j2ee.platform.classpath}"/>
      </classpath>
    </javac>

    <jar destfile="${dist.dir}/SomeFunkyJar.jar"
         basedir="${build.classes.dir}"
         includes="**/reports/*.class"/>
  </target>