public static boolean isImmediateParent(String parentPath, String childPath)
{
    int index = childPath.lastIndexOf("/");
    if (index == -1)
        throw new IllegalArgumentException("child has no parent");
    return childPath.substring(0, index).equals(parentPath);
}

isImmediateParent("a", "a") = exception
isImmediateParent("a", "a/b") = true
isImmediateParent("a", "a/b/c") = false
isImmediateParent("a", "b/a") = false