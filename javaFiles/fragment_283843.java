apply plugin: 'java'
repositories {
    mavenCentral()
}

// This is just to have some dependencies on the classpath.

dependencies {
    compile 'org.springframework.boot:spring-boot-starter:1.5.1.RELEASE'
    compile "org.webjars:webjars-locator:+"
}

// run this task to analyze all deps

task checkDeps {
    doLast {
        // this closure simply prints a given dependency and throws an exception if slf4j-api is found
        def failIfBad = { dep ->
            println "CHECKING: $dep.module.id.group:$dep.module.id.name"
            if (dep.module.id.name == 'slf4j-api') {
                throw new GradleException("$dep.module.id.group:$dep.module.id.name on classpath!")
            }
        }
        // this is a closure with recursion that calls the above failCheck on all children and their children
        def checkChildren
        checkChildren = { dep ->
            if (dep.children.size() != 0) {
                dep.children.each { child ->
                    failIfBad(child)
                    checkChildren(child)
                }
            }
        }
        // this is how you get all dependencies in the compile scope, iterate on the first level deps and then their children
        configurations.compile.resolvedConfiguration.firstLevelModuleDependencies.each { firstLevelDep ->
            failIfBad(firstLevelDep);
            checkChildren(firstLevelDep);
        }
    }
}