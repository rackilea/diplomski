<!--Creates the deployable jar file  -->
  <target name="jar" depends="compile">
    <jar destfile="${dist.dir}\de.vogella.build.test.ant.jar" basedir="${build.dir}">
      <manifest>
        <attribute name="Main-Class" value="test.Main" />
      </manifest>
    </jar>
  </target>