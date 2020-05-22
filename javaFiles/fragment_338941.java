<jar destfile="app.jar" basedir="${classes.dir}">
    <zipfileset excludes="META-INF/**/*" src="${lib.dir}/bcprov-jdk16-145.jar"></zipfileset>
    <manifest>
        <attribute name="Main-Class" value="app.Main"/>
    </manifest>
</jar>