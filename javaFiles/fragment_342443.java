sourceSets {
    main {
        java {
            srcDirs 'src/main/java'
            srcDirs "${path1}/${path2}"
        }
    }
 }