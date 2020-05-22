sh "docker run " +
            "--name maven-module-${BUILD_ID} " +
            "--user ${env.BUILD_USER_ID}:${env.BUILD_USER_ID}" +
            "--rm " +
            "-v ${WORKSPACE}:/build " +
            "-e http_proxy=\"${http_proxy}\" " +
            "-e https_proxy=\"${https_proxy}\" " +
            "-e HTTP_PROXY=\"${http_proxy}\" " +
            "-e HTTPS_PROXY=\"${https_proxy}\" " +
            "-e MAVEN_OPTS=\"-Dhttp.proxyHost=<HTTP_PROXY> -Dhttp.proxyPort=<HTTP_PROXY_PORT>-Dhttps.proxyHost=HTTP_PROXY> -Dhttps.proxyPort=<HTTP_PROXY_PORT>\" " +
            "docker-maven clean package -f /build/path-to-maven-repository/pom.xml"
}