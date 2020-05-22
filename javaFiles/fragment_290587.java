<target name="stop" depends="-check-status" if="${start.successful}">
    <java jar="${jboss.home}/jboss-modules.jar" fork="true">
        <arg line="-mp ${jboss.home}/modules org.jboss.as.cli -c command=:shutdown" />
    </java>

    <sleep seconds="10" />
    <delete quiet="false" includeEmptyDirs="true">
        <fileset dir="${jboss.home}/standalone/deployments/">
            <include name="**/*" />
        </fileset>
    </delete>
</target>