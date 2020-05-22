user = sh(returnStdout: true, script: 'id -u').trim()
group = sh(returnStdout: true, script: 'id -g').trim()
sh "docker run " +
            "--name maven-module-${BUILD_ID} " +
            "--user $user:$group" +
            …