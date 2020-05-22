pipeline {
    agent any

    tools{
       maven 'localmaven' 
    }
    stages {
        stage('Build') { 
            steps {
               sh 'mvn clean install' 
            }
            post {
               success {
                    echo 'Now Archiving...'
                   }
              } 
          }

        stage('Release') { 
            steps {
               sh 'elease:prepare release:perform' 
            }
            post {
               success {
                    ////
                   }
              } 
          }

      stage('NonProd-Deliver') {
          steps {
               /*
               You can extract the version from pom.xml,replace you project location in jenkins workspace in the below command
               */
               sh 'version=$(echo -e 'setns x=http://maven.apache.org/POM/4.0.0\ncat /x:project/x:version/text()' | xmllint --shell ${YOUR_PROJECT_LOCATION}/pom.xml | grep -v /)'
               sh 'scp -v -o StrictHostKeyChecking=no  -i /var/lib/jenkins/secrets/mykey target/*.jar ubuntu@00.00.00.00:/home/ubuntu/SNAPSHOT/${version}'
               sh "sshpass -p password ssh -o StrictHostKeyChecking=no -i /var/lib/jenkins/secrets/mykey ubuntu@00.00.00.00 '/home/ubuntu/start.sh nonprod $version'"
          }
      }

       stage('Prod-Deliver') {
        steps {
              /*
               For production release you should pass the version as a parameter to your jenkins pipeline which is going to be in production
               */
             sh 'scp -v -o StrictHostKeyChecking=no  -i /var/lib/jenkins/secrets/mykey target/*.jar ubuntu@00.00.00.00:/home/ubuntu/RELEASE/${version} '
             sh "sshpass -p password ssh -o StrictHostKeyChecking=no -i /var/lib/jenkins/secrets/mykey ubuntu@00.00.00.00 '/home/ubuntu/start.sh prod ${version}'"
        }
    }

}
}