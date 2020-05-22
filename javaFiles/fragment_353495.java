List groovy = ["org.codehaus.groovy:groovy-all:2.4.4@jar",
               "commons-cli:commons-cli:1.0@jar",
               "org.apache.ant:ant:1.9.4@jar"]
List hibernate = ['org.hibernate:hibernate:3.0.5@jar',
                  'somegroup:someorg:1.0@jar']
dependencies {
    runtime groovy, hibernate
}