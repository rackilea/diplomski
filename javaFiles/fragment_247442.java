plugins { // [2]
    id 'groovy'
}

repositories { mavenCentral() } // [3]

dependencies { // [4]
    testCompile 'org.codehaus.groovy:groovy-all:2.4.8'
    compile 'org.codehaus.groovy:groovy-all:2.4.8'
    testCompile 'junit:junit:4.12'
}