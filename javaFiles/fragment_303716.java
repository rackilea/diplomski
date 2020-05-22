...
<properties>
    <!-- Hudson properties: see http://wiki.hudson-ci.org/display/HUDSON/Building+a+software+project#Buildingasoftwareproject-HudsonSetEnvironmentVariables -->
    <jenkins.buildId>${env.BUILD_ID}</jenkins.buildId>
    <jenkins.buildNumber>${env.BUILD_NUMBER}</jenkins.buildNumber>
    <jenkins.buildTag>${env.BUILD_TAG}</jenkins.buildTag>
    <jenkins.cvsBranch>${env.CVS_BRANCH}</jenkins.cvsBranch>
    <jenkins.executorNumber>${env.EXECUTOR_NUMBER}</jenkins.executorNumber>
    <jenkins.hudsonUrl>${env.HUDSON_URL}</jenkins.hudsonUrl>
    <jenkins.javaHome>${env.JAVA_HOME}</jenkins.javaHome>
    <jenkins.jobName>${env.JOB_NAME}</jenkins.jobName>
    <jenkins.svnRevision>${env.SVN_REVISION}</jenkins.svnRevision>
    <jenkins.workspace>${env.WORKSPACE}</jenkins.workspace>
</properties>
...