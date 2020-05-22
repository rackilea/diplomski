String libName = "";
if (SystemUtils.IS_OS_WINDOWS) {
    libName = "opencv_java320.dll";
} else if (SystemUtils.IS_OS_LINUX) {
    libName = "libopencv_java320.so";
}
System.load(new File("./libs/".concat(libName)).getAbsolutePath());