<target name="distribute" depends="compile">
  <jar destfile="${distributionDir}/myjar.jar" >
    <fileset dir="${outputDir}"/>
    <fileset dir="${sourceDir}"/>
    <fileset dir="${resourcesDir}" />
  </jar>
</target>