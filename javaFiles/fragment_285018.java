jfxmobile {
    ios {
        forceLinkClasses = [ 'nl.softwork.**.*', 
                             'com.gluonhq.**.*', 
                             'org.jfxtras.**.*',
                             ...  ]
        infoPList = file('src/ios/Default-Info.plist')
   }
}