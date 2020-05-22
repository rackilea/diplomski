repositories {
   ivy {
      name = 'AngularJS'
      url = 'https://code.angularjs.org/'
      layout 'pattern', {
         artifact '[revision]/[module](.[classifier]).[ext]'
      }
   }
}

configurations {
   angular
}

dependencies {
   angular group: 'angular', name: 'angular', version: '1.3.9', classifier: 'min', ext: 'js'
}

task fetch(type: Copy) {
   from configurations.angular
   into 'src/main/webapp/js'
   rename {
      'angular.js'
   }
}