<target name="run" depends="jar">
  <exec dir="${work.dir}" executable="java" input="${work.dir}/inputfile.txt">
    <arg value="-jar"/>
    <arg file="${dist.jar}"/>
  </exec>
</target>