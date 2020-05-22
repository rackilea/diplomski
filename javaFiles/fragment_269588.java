import com.android.build.gradle.LibraryPlugin
import org.aspectj.bridge.IMessage
import org.aspectj.bridge.MessageHandler
import org.aspectj.tools.ajc.Main

apply plugin: 'com.android.library'


dependencies {
    compile 'org.aspectj:aspectjrt:1.8.5'
}
android {
    compileSdkVersion 22
    buildToolsVersion "22.0.1"

    defaultConfig {
        minSdkVersion 14
        targetSdkVersion 22
        versionCode 1
        versionName "1.0"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

android.libraryVariants.all { variant ->
    LibraryPlugin plugin = project.plugins.getPlugin(LibraryPlugin)
    JavaCompile javaCompile = variant.javaCompile
    javaCompile.doLast {
        String[] args = [
                "-showWeaveInfo",
                "-1.5",
                "-inpath", javaCompile.destinationDir.toString(),
                "-aspectpath", javaCompile.classpath.asPath,
                "-d", javaCompile.destinationDir.toString(),
                "-classpath", javaCompile.classpath.asPath,
                "-bootclasspath", android.bootClasspath.join(File.pathSeparator)
        ]

        MessageHandler handler = new MessageHandler(true);
        new Main().run(args, handler)

        def log = project.logger
        for (IMessage message : handler.getMessages(null, true)) {
            switch (message.getKind()) {
                case IMessage.ABORT:
                case IMessage.ERROR:
                case IMessage.FAIL:
                    log.error message.message, message.thrown
                    break;
                case IMessage.WARNING:
                case IMessage.INFO:
                    log.info message.message, message.thrown
                    break;
                case IMessage.DEBUG:
                    log.debug message.message, message.thrown
                    break;
            }
        }
    }
}