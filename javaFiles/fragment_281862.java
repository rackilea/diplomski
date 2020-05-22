externalNativeBuild {
    cmake {
        arguments '-DBUILD_TESTING=OFF', '-DANDROID_TOOLCHAIN=gcc-4.9'
        cppFlags "-std=c++14 -fexceptions -frtti"
    }
}