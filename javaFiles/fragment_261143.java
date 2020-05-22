File getFile(File f, String name) {
    if (f.isDirectory()) {
        for (File c : ((Directory) f).getChildren()) {
            if (c.getName().equals(name))
                return c;
        }
    }
    return null;
}