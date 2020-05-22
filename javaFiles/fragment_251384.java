IClasspathEntry[] entries = javaProject.getRawClasspath();
IClasspathEntry[] newEntries = new IClasspathEntry[entries.length + 1];

 System.arraycopy(entries, 0, newEntries, 0, entries.length);

 // add a new entry using the path to the container
 //Path junitPath = new Path("D:\\jarscan.jar");
 IClasspathEntry junitEntry = JavaCore.newLibraryEntry(new Path("D:\\jarscan.jar"), null, null, false);
 newEntries[entries.length] = junitEntry;
 javaProject.setRawClasspath(newEntries, null);