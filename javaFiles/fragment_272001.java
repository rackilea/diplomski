<target name="BuildJar">
    <property name="liblocation" location="${libdir}" />
    <pathconvert property="jarclasspathstring" pathsep=" ">
        <path>
            <fileset dir="${liblocation}">
                <include name="*.jar" />
            </fileset>
        </path>
        <map from="${liblocation}" to="." />
    </pathconvert>
    <jar destfile="${builddir}/${jarname}" basedir="${bindir}" update="true" level="9" index="false" filesOnly="true">
        <manifest>
            <attribute name="Main-Class" value="${mainclass}" />
            <attribute name="Class-Path" value="${jarclasspathstring}" />
        </manifest>
    </jar>
</target>