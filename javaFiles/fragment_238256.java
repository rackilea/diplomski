buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath("org.ajoberstar:grgit:1.5.0")
    }
}
import org.ajoberstar.grgit.Grgit
// .. rest of your build script