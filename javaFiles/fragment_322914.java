mvn deploy:deploy-file 
-Dfile=${bamboo.artifacts.path.cbaFile} 
-Dpackaging=cba 
-DgeneratePom=false 
-DupdateReleaseInfo=true 
-Durl=https://nexus.organisation.com/content/repositories/snapshots  
-DrepositoryId=snapshots  
-DgroupId=com.organisation.dept 
-DartifactId=myproject 
-Dversion=0.0.1-SNAPSHOT