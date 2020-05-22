flavorDimensions 'delivery'
productFlavors {
    instant {
        dimension 'delivery'
        minSdkVersion rootProject.minSdkInstant
        multiDexEnabled true
    }
    installed {
        dimension 'delivery'
    }
}