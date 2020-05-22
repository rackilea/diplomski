stage('Deploy') {
  steps {
        script{
            unstash 'targetfiles'
            sh 'docker build image-name:test'
        }
  }
}