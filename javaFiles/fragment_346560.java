import org.apache.tools.ant.filters.ReplaceTokens

task sourcesForRelease(type: Copy) {
    from 'src/main/java'
    into 'build/adjustedSrc'
    filter(ReplaceTokens, tokens: [VERSION: '2.3.1'])
}

task compileForRelease(type: JavaCompile, dependsOn: sourcesForRelease) {
    source = sourcesForRelease.destinationDir
    classpath = sourceSets.main.compileClasspath
    destinationDir = file('build/adjustedClasses')
}