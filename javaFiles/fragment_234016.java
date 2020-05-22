android {
    defaultConfig {

        // ...

        ndk {
            abiFilters 'armeabi-v7a', 'arm64-v8a' // 'x86', 'x86_64' may be added
        }
   }

   // ...

    task ndkClean(type: Delete) {
        // remove unused archs from build cache
        delete fileTree('.externalNativeBuild') {
            exclude defaultConfig.ndk.abiFilters.collect { '**/' + it }
        }
    }
    tasks.findByPath(':clean').dependsOn ndkClean
}