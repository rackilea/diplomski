buildscript {

   repositories {
       jcenter()
       mavenCentral()
   }

   dependencies {
       classpath "io.realm:realm-transformer:5.8.0"
   }
}
import io.realm.transformer.RealmTransformer
android.registerTransform(new RealmTransformer(rootProject))