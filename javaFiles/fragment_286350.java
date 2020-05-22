List<String> list = Arrays.asList(
"root/dir1/dir2/dir3/dir4/dir5/baseDir1/",
"root/dir1/dir2/dir3/dir4/dir5/baseDir1/subDir/", 
"root/dir1/dir2/dir3/dir4/dir5/baseDir2/", 
"root/dir1/dir2/dir3/dir4/dir5/baseDir2/subDir/", 
"root/dir1/dir2/dir3/dir4/dir5/baseDir3/", 
"root/dir1/dir2/dir3/dir4/dir5/baseDir3/subDir/",
"root/dir1/dir2/dir3/dir4/dir5/baseDir4/", 
"root/dir1/dir2/dir3/dir4/dir5/baseDir4/subDir/",
"root/dir1/dir2/dir3/dir4/dir5/baseDir5/", 
"root/dir1/dir2/dir3/dir4/dir5/baseDir5/subDir/", 
"root/dir1/dir2/dir3/dir4/dir5/baseDir6/",
"root/dir1/dir2/dir3/dir4/dir5/baseDir6/subDir/");

Set<String> dirSet = new LinkedHashSet<>(list); 
Set<Path> allDirs = new LinkedHashSet<>();
for (String file : dirSet) {
    recur(allDirs, Paths.get(file));
} 

for (Path path : allDirs) {
    System.out.println("mkdir " + path);
}

...

public static void recur(Set<Path> paths, Path path) {
    if (path == null)
        return;
    recur(paths, path.getParent());
    paths.add(path);
}