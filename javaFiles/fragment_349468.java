<unzip src="${output.dir}/Scala2.11/Neo.jar" dest="${standalone.jar.expanded.jars.dir}">
    <patternset excludes="src/services/targetFile"/>
</unzip>
<unzip src="path/to/lib01.jar" dest="${standalone.jar.expanded.jars.dir}">
    <patternset excludes="src/services/targetFile"/>
</unzip>
<unzip src="path/to/lib02.jar" dest="${standalone.jar.expanded.jars.dir}">
    <patternset excludes="src/services/targetFile"/>
</unzip>
<unzip src="path/to/lib03.jar" dest="${standalone.jar.expanded.jars.dir}">
    <patternset excludes="src/services/targetFile"/>
</unzip>
<unzip src="path/to/lib04.jar" dest="${standalone.jar.expanded.jars.dir}">
    <patternset excludes="src/services/targetFile"/>
</unzip>

<concat destfile="${standalone.jar.expanded.jars.dir}/src/services/targetFile">
    <zipentry zipfile="${output.dir}/Scala2.11/Neo.jar" name="src/services/targetFile"/>
    <zipentry zipfile="path/to/lib01.jar" name="src/services/targetFile"/>
    <zipentry zipfile="path/to/lib02.jar" name="src/services/targetFile"/>
    <zipentry zipfile="path/to/lib03.jar" name="src/services/targetFile"/>
    <zipentry zipfile="path/to/lib04.jar" name="src/services/targetFile"/>
</concat>