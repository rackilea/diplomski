configurations {
    serviceTestCompile
}

sourceSets {
    serviceTest {
        compileClasspath = configurations.serviceTestCompile
    }
}

dependencies {
    serviceTestCompile "org.testng:testng:5.8"
}