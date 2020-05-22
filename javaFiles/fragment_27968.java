android {
    compileSdkVersion 18
    buildToolsVersion "21.1.2"

    sourceSets {
        main {
            manifest.srcFile 'AndroidManifest.xml'
            java.srcDirs = ['src\\main\\java','src\\test\\java'] // Line 1
            resources.srcDirs = ['src\\main\\java','src\\test\\java'] // Line 2
            aidl.srcDirs = ['src\\main\\java','src\\test\\java']
            renderscript.srcDirs = ['src\\main\\java','src\\test\\java']
            res.srcDirs = ['res']
            assets.srcDirs = ['assets']
        }

        instrumentTest.setRoot('tests')
    }
}