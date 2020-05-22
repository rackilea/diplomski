public boolean accept(File dir, String name) {
    if (name == null) {
        return false;
    }

    return new File(dir, name).isDirectory() || name.toLowerCase().endsWith(".zip");
}