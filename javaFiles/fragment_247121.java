<target name="all" depends="build.modules, build.all.artifacts, yguard"
          description="build all">
      <!-- Delete temporary files -->
      <delete dir="${artifacts.temp.dir}"/>

  </target>