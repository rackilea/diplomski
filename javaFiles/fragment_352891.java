<target name="generate-installer-exe" depends="generate-exe">
  <exec executable="C:/Program Files (x86)/Inno Setup 5/ISCC.exe">
    <arg value="${etc.dir}/innoSetup_config.iss"/>
    <arg value="/dMySourcePath=${deployment.dir}"/>
    <arg value="/O${deployment.dir}"/>
  </exec>
</target>