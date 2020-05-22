<properties>
    <tmpdirectory>${java.io.tmpdir}${file.separator}${user.name}-${project.groupId}-${project.artifactId}</tmpdirectory>
</properties>
...
        <plugin>
            <!-- clean tmp directory at every "mvn clean" -->
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-clean-plugin</artifactId>
            <version>2.4.1</version>
            <configuration>
                <filesets>
                    <fileset>
                        <directory>${tmpdirectory}</directory>
                    </fileset>
                </filesets>
            </configuration>
        </plugin>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-antrun-plugin</artifactId>
            <version>1.6</version>
            <dependencies>
                  <dependency>
                      <groupId>com.sun</groupId>
                      <artifactId>tools</artifactId>
                      <version>1.6.0</version>
                      <scope>system</scope>
                      <systemPath>${java.home}/../lib/tools.jar</systemPath>
                  </dependency>
            </dependencies>  
            <executions>
                <execution>
                    <!-- compile webservice classes into tmp directory -->
                    <id>mini compile of webservices</id>
                    <phase>generate-sources</phase>
                    <goals>
                        <goal>run</goal>
                    </goals>
                    <configuration>
                        <target>
                            <property name="compile_classpath" refid="maven.compile.classpath"/>
                            <mkdir dir="${tmpdirectory}" />
                            <javac includeAntRuntime="false"
                                   classpath="${compile_classpath}"
                                   destdir="${tmpdirectory}">
                                <src path="${project.build.sourceDirectory}" />
                                <include name="org/example/project/*/webservice/*.java" />
                            </javac>
                        </target>
                    </configuration>
                </execution>
                <execution>
                    <!-- delete temporary directory (in case mvn clean is not called) -->
                    <id>clean up tmp dir</id>
                    <phase>process-sources</phase>
                    <goals>
                        <goal>run</goal>
                    </goals>
                    <configuration>
                        <target>
                            <delete dir="${tmpdirectory}" />
                        </target>
                    </configuration>
                </execution>
            </executions>  
        </plugin>
        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>jaxws-maven-plugin</artifactId>
            <version>1.10</version>
            <executions>
                <execution>
                    <!-- generate WSDL file from the compiled classes in tmp directory -->
                    <id>generate wsdl file</id>
                    <phase>generate-sources</phase>
                    <goals>
                        <goal>wsgen</goal>
                    </goals>
                    <configuration>
                        <sei><!-- service endpoint implementation  --></sei>
                        <destDir>${tmpdirectory}</destDir>
                        <genWsdl>true</genWsdl>
                        <resourceDestDir>${tmpdirectory}</resourceDestDir>
                    </configuration>
                </execution>
                <execution>
                    <!-- create client stub files -->
                    <id>create client files from wsdl file</id>
                    <goals>
                        <goal>wsimport</goal>
                    </goals>
                    <configuration>
                        <keep>true</keep>
                        <wsdlDirectory>${tmpdirectory}</wsdlDirectory>
                    </configuration>
                </execution>
            </executions>
        </plugin>