<build>
    <resources>
        <resource>
            <directory>${basedir}/src/main/nbm-branding</directory>
            <!-- f.e. allow replacing ${project.version} in all property files below src/main/nbm-branding -->
            <includes>
                <include>**/*.properties</include>
            </includes>
            <filtering>true</filtering>
            <targetPath>${basedir}/target/filtered-nbm-branding</targetPath>
        </resource>
    </resources>
    <plugins>
        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>nbm-maven-plugin</artifactId>
            <configuration>
                <!-- use previously filtered branding sources -->
                <brandingSources>${basedir}/target/filtered-nbm-branding</brandingSources>
            </configuration>
        </plugin>
        <!-- ... -->
    </plugins>
</build>