public synchronized void addChild(String name, int type, FileTree parent)
{
    if (!children.containsKey(name)) {
        children.put(name, new FileTree(name, type, parent));
    }
}