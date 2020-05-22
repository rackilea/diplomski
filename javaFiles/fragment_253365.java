File dir = new File("/some/start/path");

File[] children = dir.listFiles(file -> file.isDirectory());
if (children.length > 0) {
    /* You may need a different sort order to duplicate the behavior
       of the * glob character, but for example purposes... */
    Arrays.sort(children, Comparator.comparing(File::getName));

    /* Take the first one */
    dir = children[0];
}

System.out.println("New directory is: " + dir.getAbsoluteFile());