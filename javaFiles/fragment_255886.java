ext.integrationTearDown = { 
  workingDir "$projectDir/resources/integration" 
  commandLine 'sh', './stop_service.sh' 
} 

task(type: Exec, 'stop_service', integrationTearDown) 

gradle.buildFinished { 
  exec integrationTearDown 
} 

testIntegration.dependsOn integrationSetup 
testIntegration.finalizedBy stop_service