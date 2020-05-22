apply plugin: 'com.android.application'
evaluationDependsOn(':java-code')

...

dependencies {
    compile project(":java-code")
    compile fileTree(dir: 'libs', include: ['*.jar'])

    ...
}