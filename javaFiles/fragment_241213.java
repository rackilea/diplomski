<target name="-post-jar">
    <jar jarfile="dist/PKIFrapper.jar" >
    <zipfileset src="${dist.jar}" excludes="META-INF/*" />
    <zipfileset src="src/lib/bcmail-jdk15on-155.jar" excludes="META-INF/*" />
    <zipfileset src="src/lib/bcpg-jdk15on-155.jar" excludes="META-INF/*" />
    <zipfileset src="src/lib/bcpkix-jdk15on-155.jar" excludes="META-INF/*" />
    <zipfileset src="src/lib/bcprov-ext-jdk15on-155.jar" excludes="META-INF/*" />
    <zipfileset src="src/lib/bcprov-jdk15on-155.jar" excludes="META-INF/*" />
    <zipfileset src="src/lib/bctest-jdk15on-155.jar" excludes="META-INF/*" />
    <zipfileset src="src/lib/commons-codec-1.10-javadoc.jar" excludes="META-INF/*" />
    <zipfileset src="src/lib/commons-codec-1.10-sources.jar" excludes="META-INF/*" />
    <zipfileset src="src/lib/commons-codec-1.10.jar" excludes="META-INF/*" />
    <zipfileset src="src/lib/log4j-1.2-api-2.3-javadoc.jar" excludes="META-INF/*" />
    <zipfileset src="src/lib/log4j-1.2-api-2.3-sources.jar" excludes="META-INF/*" />
    <zipfileset src="src/lib/log4j-1.2-api-2.3.jar" excludes="META-INF/*" />

    <manifest>

        <attribute name="Main-Class" value="MyLibrary.*"/>
    </manifest>
    </jar>
</target>