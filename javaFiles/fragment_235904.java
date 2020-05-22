<jar basedir="${build}/preverifiedobf"
     jarfile="${build}/bin/${program_name}.jar"
     manifest="bin/MANIFEST.MF">
  <fileset dir="${top}/${res}">
    <include name="${package_name}/*.png"/>
  </fileset>
</jar>