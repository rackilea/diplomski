if(project.name != "BaseTests")
    {
        println "$project.name depends on BaseTests"
        dependencies {
            testCompile project(':BaseTests')
            testCompile project(':BaseTests').sourceSets.test.output
        }
    }