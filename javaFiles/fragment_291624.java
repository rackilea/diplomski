task deploy(type: Copy) {
  dependsOn build

  from '/build/libs/app.war'
  into tomcat_webapps
}