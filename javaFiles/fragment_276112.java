static String getJavaRuntime() throws IOException {
    String os = System.getProperty("os.name");
    String java = System.getProperty("java.home") + File.separator + "bin" + File.separator +
            (os != null && os.toLowerCase(Locale.ENGLISH).startsWith("windows") ? "java.exe" : "java");
    if (!new File(java).isFile()) {
        throw new IOException("Unable to find suitable java runtime at "+java);
    }
    return java;
}