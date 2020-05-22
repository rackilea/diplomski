applicationVariants.all{ variant ->
  variant.processManifest.doFirst {
    File manifestFile = file("${buildDir}/exploded-aar/com.google.maps.android/android-maps-utils/0.3/AndroidManifest.xml")
    if (manifestFile.exists()) {
      String content = manifestFile.getText('UTF-8')
      content = content.replaceAll(/minSdkVersion="8"/, 'minSdkVersion=\"9\"')
      manifestFile.write(content, 'UTF-8')
    }
  }
}