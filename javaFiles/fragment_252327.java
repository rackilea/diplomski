File[] directories = new File(path).listFiles(f -> f.isDirectory() && !f.isHidden()); // loads all not hidden subdirectories, which is what you are trying to do
if (directories != null) { // listFiles can return null, so check it before iterating
    for (File a : directories) {
              rekursion(a);
    }
}