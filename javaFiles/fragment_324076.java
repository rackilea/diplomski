<copy todir="${archive.dir}">
        <fileset dir="${main.config.dir}">
            <include name="DEPLOYMENT_DIRECTIONS.txt"/>
            <include name="deploy.sh"/>
        </fileset>
        <filterset>
            <filter token="JOB_NAME"        value="${env.JOB_NAME}"/>
            <filter token="BUILD_NUMBER"    value="${env.BUILD_NUMBER}"/>
            <filter token="JENKINS_URL"     value="${env.JENKINS_URL}"/>
        </filterset>
    </copy>