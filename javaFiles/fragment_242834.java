#!/bin/sh
 #couple of safety checks
 if [ "$#" -ne 1 ]; then 
     echo "usage: ./maven-enforcer.sh <path_to_the_maven_install_lib_folder>"
     echo "1 argument required, $# provided"
     exit 1
 fi

 if [ ! -d $1 ]; then
     echo "directory '$1' does not exist, exiting..."
     exit 1
 fi

 if [ ! -e $1/maven-model-builder-3.0.5.jar ]; then
      echo "file 'maven-model-builder-3.0.5.jar' does not exist in directory $1, exiting..."
      exit 1
 fi

 #back-up the already existing jar
 cp $1/maven-model-builder-3.0.5.jar $1/maven-model-builder-3.0.5_backup.jar

 cd $1

 #unpack the contents of the jar
 jar xf $1/maven-model-builder-3.0.5.jar

 cd org/apache/maven/model/

 #test if the command did not run already
 didItRunAlready=`grep -n "maven-enforcer-plugin" pom-4.0.0.xml | cut -f1 -d:`

 if [[ ! -z "$didItRunAlready" ]]; then
    echo "Command already run once, exiting..."
    exit 1
 fi

 lineNumber=`grep -n "</pluginManagement>" pom-4.0.0.xml | cut -f1 -d:`

 textToAdd="<plugins>\n<plugin>\n<groupId>org.apache.maven.plugins</groupId>\n<artifactId>maven-enforcer-plugin</artifactId>\n<version>1.3.1</version>\n<executions>\n<execution>\n<id>enforce-no-repositories</id>\n<goals>\n<goal>enforce</goal>\n</goals>\n<configuration>\n<rules>\n<requireNoRepositories>\n<message>Best Practice is to never define repositories in pom.xml (use a repository manager instead)</message>\n</requireNoRepositories>\n</rules>\n</configuration>\n</execution>\n</executions>\n</plugin></plugins>"

 sed ""$lineNumber"a $textToAdd" pom-4.0.0.xml > result.xml 
 rm pom-4.0.0.xml
 mv result.xml pom-4.0.0.xml

 cd ../../../../

 jar vfu maven-model-builder-3.0.5.jar org/

 rm -fr META-INF
 rm -fr org

 echo "Succesfully updated maven-model-builder-3.0.5.jar"