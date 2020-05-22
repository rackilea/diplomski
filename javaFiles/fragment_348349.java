public File findFile(File dir, String name) {
    File[] children = dir.listFiles();

    for(File child : children) {
        if(child.isDirectory()) {
           File found = findFile(child, name);
           if(found != null) return found;
        } else {
            if(name.equals(child.getName())) return child;
        }
    }

    return null;
}