<exec executable="ditto" dir="${basedir}/target">
  <arg value="-c" />
  <arg value="-k" />
  <arg value="--keepParent" />
  <arg value="--sequesterRsrc" />
  <arg value="My.app" />
  <arg value="My-app.zip" />
</exec>