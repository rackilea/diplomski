<!-- Include the -dl jar created by the rmic-package goal in
        the lib part of the assembly. It is necessary because 
        the target VM does not support dynamic RMI stubs, so the 
        stubs must be deployed in the assembly. -->
   <fileSets>
       <fileSet>
           <directory>../{project}/target</directory>
           <outputDirectory>.</outputDirectory>
           <!-- put the main jar in the top level -->
           <includes>
               <include>*.jar</include>
           </includes>
           <!-- don't include the RMIC-built -dl jar at the top -->
           <excludes>
               <exclude>*-dl-*.jar</exclude>
           </excludes>
       </fileSet>
       <fileSet>
           <directory>../{project}/target</directory>
           <outputDirectory>lib</outputDirectory>
           <!-- put the RMIC-built -dl jar in the lib dir -->
           <includes>
               <include>*-dl-*.jar</include>
           </includes>
       </fileSet>
   </fileSets>
   <dependencySets>
       <dependencySet>
           <!-- put all the dependencies in lib, as usual -->
           <useProjectArtifact>false</useProjectArtifact>
           <outputDirectory>lib</outputDirectory>             
           <excludes>
               <!-- don't include the main jar, which is at 
                    the top level already. -->
               <exclude>{groupId}:{artifact}</exclude>
           </excludes>
           <unpack>false</unpack>
       </dependencySet>
   </dependencySets>