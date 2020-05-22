project(':module1') { 
   dependencies {
      compile project(':module-service-api')
      compile 'org.apache.commons:commons-lang3:3.3.2'
      compile 'log4j:log4j:1.2.17'
   }
} 

//module-app depends on module-service-impl
project(':module2') { 
   dependencies {
      compile project(':module1')
   }