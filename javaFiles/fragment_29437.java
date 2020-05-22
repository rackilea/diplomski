<manifest file="${basedir}\resources\jar\META-INF\MANIFEST.MF">
        <attribute name="Manifest-Version" value="1.0" />
        <attribute name="Version" value="${release.version}" />
        <attribute name="Company" value="S1" />
        <attribute name="Project" value="<project_name>" />
        <attribute name="Java-Version" value="1.5" />
    </manifest>
</target>

<target name="dist_jar" depends="create_manifest">
    <delete file="${basedir}\build\jar\${jar.name}" />

    <!--Create the JAR for the build-->

    <jar jarfile="${basedir}\resources\jar\${jar.name}" 
        manifest="${basedir}\resources\jar\META-INF\MANIFEST.MF" 
        basedir="${jar.classes}" />
</target>