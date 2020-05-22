apply plugin: "jacoco"

 jacoco {
 toolVersion = "0.8.4"
 reportsDir = file("$buildDir/")
  }

 tasks.withType(Test) { task -> jacoco { destinationFile = 
  file("$buildDir/reports/jacoco/${task.name}.exec") } }
 jacocoTestReport {
  reports {
    html.enabled true
    xml.enabled true
    csv.enabled true
    html.destination file("${buildDir}/jacocoHtml")
}}