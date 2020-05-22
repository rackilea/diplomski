public static boolean isRunningInEclipse(int folderDepth) {
    File projectRoot = new File(Boot.class.getProtectionDomain().getCodeSource().getLocation().getFile());       
    for (int i = 0; i < folderDepth; i++) {
        projectRoot = projectRoot.getParentFile();
        if (projectRoot == null || !projectRoot.isDirectory()) {
            return false;
        }
    }
    return new File(projectRoot, ".project").isFile();
}