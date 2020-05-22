File baseDir = new File(basePath);
File candidate = new File(fullPath);
String subPath = candidate.getName();
candidate = candidate.getParent();

while (candidate != null && !candidate.equals(baseDir))
{
    candidate = candidate.getParent();
    subPath = candidate.getName() + File.separatorChar + subPath;
}

// now if candidate == null the file is on another directory, you have to use all the path
// if candidate != null, then subpath has what you want