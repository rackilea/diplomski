task buildREPL(type: Jar, dependsOn: 'someOtherTask') {
    from sourceSets.repl.output

    from("$buildDir/dyvilbin") {
        include '**/*.dyo', '**/*.class'
    }

    // ...
}