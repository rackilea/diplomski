$ maven -version
Apache Maven 3.2.1 (ea8b2b07643dbb1b84b6d16e1f08391b666bc1e9; 2014-02-14T17:37:52+00:00)
Maven home: /usr/share/maven3
Java version: 1.7.0_80, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-7-oracle/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "3.2.0-79-generic", arch: "amd64", family: "unix"
$
$
$
$ maven -e clean heroku:deploy-war
[INFO] Error stacktraces are turned on.
[INFO] Scanning for projects...
[WARNING]
[WARNING] Some problems were encountered while building the effective model for com.example:travis-heroku-java-example:war:0.1-SNAPSHOT
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-compiler-plugin is missing. @ line 31, column 11
[WARNING]
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
[WARNING]
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
[WARNING]
[INFO]
[INFO] Using the builder org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder with a thread count of 1
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building Simple Web Application 0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ travis-heroku-java-example ---
[INFO] Deleting /home/ciuser/travis-heroku-java-example/target
[INFO]
[INFO] >>> heroku-maven-plugin:0.3.6:deploy-war (default-cli) @ travis-heroku-java-example >>>
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ travis-heroku-java-example ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/ciuser/travis-heroku-java-example/src/main/resources
[INFO]
[INFO] --- maven-compiler-plugin:2.5.1:compile (default-compile) @ travis-heroku-java-example ---
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /home/ciuser/travis-heroku-java-example/target/classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ travis-heroku-java-example ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/ciuser/travis-heroku-java-example/src/test/resources
[INFO]
[INFO] --- maven-compiler-plugin:2.5.1:testCompile (default-testCompile) @ travis-heroku-java-example ---
[INFO] No sources to compile
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ travis-heroku-java-example ---
[INFO] No tests to run.
[INFO]
[INFO] --- maven-war-plugin:2.2:war (default-war) @ travis-heroku-java-example ---
[INFO] Packaging webapp
[INFO] Assembling webapp [travis-heroku-java-example] in [/home/ciuser/travis-heroku-java-example/target/travis-heroku-java-example]
[INFO] Processing war project
[INFO] Copying webapp resources [/home/ciuser/travis-heroku-java-example/src/main/webapp]
[INFO] Webapp assembled in [38 msecs]
[INFO] Building war: /home/ciuser/travis-heroku-java-example/target/travis-heroku-java-example.war
[INFO] WEB-INF/web.xml already added, skipping
[INFO]
[INFO] <<< heroku-maven-plugin:0.3.6:deploy-war (default-cli) @ travis-heroku-java-example <<<
[INFO]
[INFO] --- heroku-maven-plugin:0.3.6:deploy-war (default-cli) @ travis-heroku-java-example ---
[INFO] Configured Artifact: com.github.jsimone:webapp-runner:7.0.57.2:jar
[INFO] Copying webapp-runner-7.0.57.2.jar to /home/ciuser/travis-heroku-java-example/target/dependency/webapp-runner.jar
[INFO] ---> Packaging application...
[INFO]      - app: boiling-beach-1111
[INFO]      - including: target/dependency/webapp-runner.jar
[INFO]      - including: target/travis-heroku-java-example.war
[INFO]      - installing: OpenJDK 1.8
[INFO] ---> Creating slug...
[INFO]      - file: target/heroku/slug.tgz
[INFO]      - size: 56MB
[INFO] ---> Uploading slug...
[INFO]      - stack: cedar-14
[INFO]      - process types: [web]
[INFO] ---> Releasing...
[INFO]      - version: 6
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 32.265 s
[INFO] Finished at: 2015-04-24T20:05:46+00:00
[INFO] Final Memory: 19M/48M
[INFO] ------------------------------------------------------------------------