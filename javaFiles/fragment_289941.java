defaultConfig {
    ...
    ndk {
        moduleName "my-module-name"
        cFlags "-std=c++11 -fexceptions"
        ldLibs "log"
        stl "gnustl_shared"
        abiFilter "armeabi-v7a"
    }
}