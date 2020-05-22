// new parameter here: parent directory
public void walkDir(String pathname, File parent) {
  System.out.println(pathname);

  File d = new File(parent, pathname); // <-- File constructor with parent
  recursiveList.add(d);
  if(d.isDirectory()) {
    for(String f : d.list()) {
      walkDir(f, d);                   // passing parent here
    }
  }
}

// entry point, to keep old interface.
public void walkDir(String pathname) {
  walkDir(pathname, null);
}