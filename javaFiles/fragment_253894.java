<!-- code sign -->
<exec executable="chmod">
    <arg line="a+w ${build.dir}/Mac/MyApp.app/Contents/PlugIns/jre"/>
</exec>

<apply executable="codesign"> <!-- note: this loops through the contents of dir -->
    <arg line="-f -s 'Developer ID Application: My Organization'"/>
    <fileset dir="${build.dir}/Mac/MyApp.app/Contents/PlugIns/jre" />
</apply>

<exec executable="codesign" dir="${build.dir}/Mac"> 
    <arg line="-f -s 'Developer ID Application: My Organization' MyApp.app/Contents/PlugIns/jre"/>
</exec>

<exec executable="codesign" dir="${build.dir}/Mac"> 
    <arg line="-f -s 'Developer ID Application: My Organization' MyApp.app/Contents/PlugIns/jre/Contents/_CodeSignature/CodeResources"/>
</exec>

<!-- also codesign anything else in _CodeSignature (see comments) -->

<exec executable="codesign" dir="${build.dir}/Mac">
    <arg line="-f -s 'Developer ID Application: My Organization' MyApp.app"/>
</exec>


<!-- verify codesign -->
<exec executable="codesign" dir="${build.dir}/Mac" failonerror="true">
    <arg line="-vv MyApp.app"/>
</exec>


<!-- verify gatekeeper -->
<exec executable="spctl" dir="${build.dir}/Mac" failonerror="true">
    <arg line="-vv --assess --type execute MyApp.app"/>
</exec>