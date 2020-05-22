public void findFiles(String filePath) throws IOException {
  //we use a Deque<> for Last In First Out ordering (to keep subfolders with their parent)
  Deque<Path> paths = new ArrayDeque<Path>();  
  paths.add(Paths.get(filePath);
  return findFilesRecursive(paths);  
}

private void findFilesRecursive(Deque<Path> pending) {
  if (pending.isEmpty()) {
    //base case, we are ready
    return;
  }

  Path path = pending.removeFirst();
  if (Files.isRegularFile(path)) {
    //todo: process the file

  } else {
      //it is a directory, queue its subfolders for processing
     List<Path> inside = Files.list(path).collect(Collectors.toList());
     if (inside.isEmpty() {
       Files.delete(path);
     } else {
       //we use LIFO so that subfolders get processed first
       inside.forEach(pending::addFirst);
     }
  }

  //tail recursion, we do nothing after we call it
  return findFilesRecursive(pending);  
}