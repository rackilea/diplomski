Path[] chunks = new Path[2]; //two chunks should be enough
Path currentPath;

private void reCreatePath(){
    currentPath = new Path(chunks[0]);
    currentPath.addPath(chunks[1]);
}