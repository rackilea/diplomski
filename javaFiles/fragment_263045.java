for (int i = 0; children != null && i < children.length; i++) {
    File result = traverse(new File(dir, children[i]),name.trim());
    if(result != null) {
       return result;
    }
}