<resource>
    <directory>src/main/resources/${environment}/app-context</directory>
        <filtering>false</filtering>
        <includes>
            <include>*</include>
        </includes>
    <targetPath>${project.build.directory}/${warName}/WEB-INF</targetPath>
</resource>