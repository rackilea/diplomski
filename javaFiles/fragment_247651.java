pipeline {
    stages {
        stage ('start') {
            ...
        }
     }

     post {
        always {
            sh "docker system prune -f"
        }
     }
}