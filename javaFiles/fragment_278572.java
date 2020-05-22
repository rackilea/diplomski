[INFO] BUILD FAILURE
 [INFO] ------------------------------------------------------------------------
 [INFO] Total time: 1.774 s
 [INFO] Finished at: 2018-08-07T17:13:29-05:00
 [INFO] ------------------------------------------------------------------------
 [ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.7.0:compile (default-compile) on project health1: Compilation failure: Compilation failure: 
 [ERROR] error reading /Users/xxx/.m2/repository/org/springframework/boot/spring-boot-actuator-autoconfigure/2.0.4.RELEASE/spring-boot-actuator-autoconfigure-2.0.4.RELEASE.jar; ZipFile invalid LOC header (bad signature)
 [ERROR] error reading /Users/xxx/.m2/repository/org/springframework/boot/spring-boot-actuator/2.0.4.RELEASE/spring-boot-actuator-2.0.4.RELEASE.jar; ZipFile invalid LOC header (bad signature)
 [ERROR] error reading /Users/xxx/.m2/repository/io/micrometer/micrometer-core/1.0.6/micrometer-core-1.0.6.jar; ZipFile invalid LOC header (bad signature)
 [ERROR] /Users/georgedeprez/Documents/workspace-sts/health1/src/main/java/com/finantica/test/health1/Health1Application.java:[1,1] cannot access com.finantica.test.health1
 [ERROR]   invalid code lengths set
 [ERROR] -> [Help 1]
 org.apache.maven.lifecycle.LifecycleExecutionException: Failed to execute goal    org.apache.maven.plugins:maven-compiler-plugin:3.7.0:compile (default-compile) on project health1: Compilation failure