sourceSets {
    otherTest {
        java {
            srcDir 'src/test/java'
            include 'org/foo/test/rest/**'
        }
        resources {
            srcDir 'src/test/java'
        }
    }
    test {
        java {
            srcDir 'src/test/java'
            exclude 'org/foo/rest/test/**'
        }
        resources {
            srcDir 'src/test/java'
        }
    }
}