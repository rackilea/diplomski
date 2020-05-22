<jar jarfile="${dist}/MyJar.jar" basedir="${build}">
  <manifest>
    <attribute name="Main-Class" value="MyClass"/>
    <attribute name="Class-Path" value="."/>
  </manifest>
</jar>