sourceSets {
    main {
        java {
            srcDir 'src'
            exclude 'net/codetojoy/tests/*'
        }
    }
}

sourceSets.test.java.srcDir 'src/net/codetojoy/tests'