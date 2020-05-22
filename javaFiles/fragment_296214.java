<jar destfile="printTarget.jar">
  <fileset dir="${classes.dir}" />
  <manifest>
    <attribute name="Main-Class" value="com.example.Main" />
  </manifest>
  <!-- This is just a way to create a zip entry from inline text in the build
       file without having to <echo> it to a real file on disk first -->
  <mappedresources>
    <mergemapper to="com/example/buildinfo.properties"/>
    <string encoding="ISO-8859-1"># this is a generated file, do not edit
      targetname=custom-build-1
    </string>
  </mappedresources>
</jar>