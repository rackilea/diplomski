android {

  signingConfigs {
      flavor1 {
          storeFile file("keystore")
          storePassword "secret"
          keyAlias "aliasForFlavor1"
          keyPassword "secretFlavor1"
      }

      flavor2 {
          storeFile file("keystore")
          storePassword "secret"
          keyAlias "aliasForFlavor2"
          keyPassword "secretFlavor2"
      }
  }

defaultConfig {...}
buildTypes {...}
productFlavors {
  def demoSigning = signingConfigs.flavor1
  def fullSigning = signingConfigs.flavor2
    demo {
        signingConfig demoSigning
        applicationIdSuffix ".demo"
        versionNameSuffix "-demo"
    }
    full {
        signingConfig fullSigning
        applicationIdSuffix ".full"
        versionNameSuffix "-full"
    }
  }
}