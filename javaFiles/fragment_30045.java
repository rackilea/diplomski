jfxmobile {
    android {
        manifest = 'src/android/AndroidManifest.xml'
        packagingOptions {
            exclude 'META-INF/INDEX.LIST'
        }
    }

    ios {
        forceLinkClasses = [ 'com.gluonhq.**.*', 'com.mysql.**.*']
        infoPList = file('src/ios/Default-Info.plist')
    }
}