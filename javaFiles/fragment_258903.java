## archetype-resources/pom.xml
## assumes the template variable holding the main class list is mainClassAnswer
#set( $mainClasses = $mainClassAnswer.split(","))

.... basic POM elements here ....

<profiles>
#set ( $loopCount = 0 )
#foreach( $mainClass in $mainClasses )
  #set ( $trimmedMainClass = $mainClass.trim() )
  #set ( $loopCount = $loopCount + 1 )
  <profile>
      <id>Main${loopCount}</id>
      <build>
          <plugins>
              <plugin>
                  <groupId>org.codehaus.mojo</groupId>
                  <artifactId>exec-maven-plugin</artifactId>
                  <configuration>
                      <executable>java</executable>
                      <arguments>
                          <argument>${trimmedMainClass}</argument>
                      </arguments>
                  </configuration>
              </plugin>
          </plugins>
      </build>
  </profile>
#end
</profiles>
.... rest of POM here ....