<copy todir="...">
  <fileset dir="${root}/default" includes="**/*" excludes="file1" />
</copy>
<copy todir="...">
  <fileset dir="${root}/level1" includes="**/*" overwrite="true" />
</copy>
<copy todir="...">
  <fileset dir="${root}/level2" includes="**/*" excludes="file2" overwrite="true" />
</copy>