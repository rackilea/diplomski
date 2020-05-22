<jar jarfile="${jar.name}">
  <fileset dir="${classes.dir}">
     <include name="**/*.*"/>
  </fileset>
  <manifest>
     <attribute name="Main-Class" value="MyApp"/>
  </manifest>
</jar>