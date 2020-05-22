sourceSets {
    main {
        manifest.srcFile 'src/main/AndroidManifest.xml'
        java.srcDirs = ['src/main/java']
        resources.srcDirs = ['src/main/java']
        aidl.srcDirs = ['src/main/java']
        renderscript.srcDirs = ['src/main/java']
        res.srcDirs = ['src/main/res']
        assets.srcDirs = ['src/main/assets']
    }
}