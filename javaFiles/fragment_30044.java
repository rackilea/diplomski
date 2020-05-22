jfxmobile {
    android {
        manifest = 'src/android/AndroidManifest.xml'
        packagingOptions {
            exclude 'META-INF/INDEX.LIST'
        }
        // typo!! iOS should be outside android!
        ios {
            infoPList = file('src/ios/Default-Info.plist')
            forceLinkClasses = ['com.mtt8.**.*', 'com.mysql.**.*']
        }
    }