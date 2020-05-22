<library id="someLibrary">
   <!-- All the jar files in ther servers lib folder -->
   <fileset dir="${server.config.dir}/lib" includes="*.jar" scanInterval="5s" />
</library>

<application location ="webStore.war">
   <classloader commonLibraryRef="someLibrary" />
</application>