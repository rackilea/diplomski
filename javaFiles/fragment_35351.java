dexOptions {
            incremental = true;
            preDexLibraries = false
            javaMaxHeapSize "4g" // 2g should be also OK
        }

compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_7
        targetCompatibility JavaVersion.VERSION_1_7
    }