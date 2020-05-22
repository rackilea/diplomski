repositories {
    flatDir {
        dirs 'libs'  // place the aar in here
    }
}
dependencies {
    compile(name:'fileNameOfAarWithoutExtension', ext:'aar')
}