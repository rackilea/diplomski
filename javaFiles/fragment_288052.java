public static void loadOpenCVLib() throws Exception {
    File file = new File(OpenCVUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    File opencv_libs = new File("oc_lib"); // this path is where is the lib going to copy to
    String model = System.getProperty("sun.arch.data.model");
    String localLibPath; // this is the path inside your program resource
    if (model.equals("64")) {
        localLibPath = "oc_lib/64bit";
    } else {
        localLibPath = "oc_lib/x86";
    }
    if (file.isFile()) { // when run from jar
        JarFile jar = new JarFile(file);
        if (!opencv_libs.exists() || !opencv_libs.isDirectory()) {
            try {
                JarUtils.copyResourcesToDirectory(jar, localLibPath, opencv_libs.getAbsolutePath());
            } catch (Exception e) {
                throw new IOException("Failed to create load opencv libs!!");
            }
        } else {
            String[] list = opencv_libs.list();
            if (list != null && list.length != 2) {
                try {
                    JarUtils.copyResourcesToDirectory(jar, localLibPath, opencv_libs.getAbsolutePath());
                } catch (Exception e) {
                    throw new IOException("Failed to create load opencv libs!!");
                }
            }
        }
    } else { // when run from IDE
        File libPath = new File(OpenCVUtil.class.getResource("/"+localLibPath).getFile());
        if (!opencv_libs.exists() || !opencv_libs.isDirectory()) {
            boolean isDone = opencv_libs.mkdir();
            if (!isDone && !opencv_libs.exists()) {
                throw new IOException("Failed to create load opencv libs!!");
            }
            try {
                FileUtils.copyDirectory(libPath, opencv_libs);
            } catch (IOException e) {
                throw new IOException("Failed to create load opencv libs!!");
            }
        } else {
            String[] list1 = opencv_libs.list();
            String[] list2 = libPath.list();
            boolean contentEquals = list1 != null && list2 != null && list1.length == list2.length;
            if (contentEquals) {
                try {
                    FileUtils.copyDirectory(libPath, opencv_libs);
                } catch (IOException e) {
                    throw new IOException("Failed to create load opencv libs!!");
                }
            }
        }
    }
    System.setProperty("java.library.path", opencv_libs.getAbsolutePath());
    Field sys_paths = ClassLoader.class.getDeclaredField("sys_paths");
    sys_paths.setAccessible(true);
    sys_paths.set(null, null);
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    // it is for the ffmpeg name
    String[] list = opencv_libs.list();
    assert list != null;
    String ffmpeg_dll_file_name = null;
    for (String s : list) {
        if (s.contains("ffmpeg")) {
            ffmpeg_dll_file_name = s.substring(0, s.indexOf("."));
        }
    }
    System.loadLibrary(ffmpeg_dll_file_name);
}