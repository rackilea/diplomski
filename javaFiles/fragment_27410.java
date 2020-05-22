<!-- Create Jar File -->
    <target name="buildJar" depends="build">
        <jar destfile="${jarDir}/${jarFile}" basedir="${jarClassdir}">
            <zipfileset dir="${base.dir}" prefix="META-INF" includes="weblogic-ejb-jar.xml" />
        </jar>
    </target>

    <!-- Create War File -->
    <target name="buildWar" depends="buildJar">
        <war destfile="${warDir}/${warFile}" webxml="${web}/WEB-INF/web.xml">
            <fileset dir="${web}" />
            <classes dir="${warClassdir}" />
        </war>
    </target>