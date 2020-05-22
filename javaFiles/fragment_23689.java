ext{
    // path to catalina.properties in your project
    catalinaPropertiesPath = 'src/main/conf/catalina.properties'

    // path to temporary directory used by gradle-tomcat plugin
    tomcatTmpRunDir = "$buildDir/tmp/tomcatRun/conf"
}

// copy catalina.properties conf file
task copyCatalinaProperties(type: Copy){
    from( catalinaPropertiesPath)
    into(tomcatTmpRunDir)

}

// create task dependency
tomcatRun.dependsOn copyCatalinaProperties