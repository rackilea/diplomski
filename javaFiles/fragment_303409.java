IVMInstall jre = JavaRuntime.getDefaultVMInstall();         
File jdkHome = jre.getInstallLocation();
IPath toolsPath = new Path(jdkHome.getAbsolutePath())
       .append("lib")
       .append("tools.jar");
IRuntimeClasspathEntry toolsEntry =
   JavaRuntime.newArchiveRuntimeClasspathEntry(toolsPath);
toolsEntry.setClasspathProperty(IRuntimeClasspathEntry.USER_CLASSES);