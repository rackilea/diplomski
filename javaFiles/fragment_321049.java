...
dependencies {
    ...
    compile project(':project1-internal-module')
    compile project(':..:shared-module1')
    compile project(':..:shared-module2')
}