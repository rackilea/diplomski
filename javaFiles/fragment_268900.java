buildscript {
  ext.kotlin_version = '1.3.50'
  repositories {
     google()
     jcenter()
  }

 dependencies {
    classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
  }
}