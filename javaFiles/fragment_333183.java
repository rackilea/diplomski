plugins {
    id 'java' // possibly use java-base or just custom zip task, since client doesn't actually compile java
}

jar {
    dependsOn buildProduction // task that compiles my stuff into build/dist
    baseName 'front'
    classifier 'SNAPSHOT-' + new Date().format('yyyyMMddHHmmss')
    from(buildDir.absolutePath + '/dist') {
        into 'static'
    }
}

// Note there is a lot of other tasks here that actually compile my stuff, like gulp-sass and JSPM bundling with babel transpiler.