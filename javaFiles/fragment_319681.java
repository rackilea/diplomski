buildscript {
    repositories {
        jcenter()
        mavenCentral()
        maven { url 'http://oss.jfrog.org/artifactory/oss-snapshot-local/' }
        //mavenLocal()
    }
    dependencies {
        classpath 'org.asciidoctor:asciidoctor-gradle-plugin:1.5.3'
        classpath 'org.asciidoctor:asciidoctorj-pdf:1.5.0-alpha.10.1'
        classpath 'io.github.swagger2markup:swagger2markup-gradle-plugin:1.2.0', {
          exclude group: 'io.github.swagger2markup', module: 'swagger2markup-gradle-plugin'
        }
        classpath files('libs/swagger2markup-1.3.1-SNAPSHOT.jar')   // YOUR VERSION
        classpath "io.github.swagger2markup:swagger2markup-import-files-ext:1.2.0", {
          exclude group: 'io.github.swagger2markup', module: 'swagger2markup-gradle-plugin'
        }
        classpath "com.bluepapa32:gradle-watch-plugin:0.1.5"
        classpath "org.kordamp.gradle:livereload-gradle-plugin:0.2.1"
    }
}