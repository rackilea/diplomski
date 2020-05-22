public static void main(String[] args) {
    System.out.println(isInsideHome("/home/user2/picture.png", "user1"));
    System.out.println(isInsideHome("/home/user1/file1.txt", "user1"));
    System.out.println(isInsideHome("/", "user1"));
    System.out.println(isInsideHome("/home", "user2"));
}

private static boolean isInsideHome(String pathStr, String leaf) {
    File path = new File(pathStr);
    File search = new File(leaf);
    while ((path = path.getParentFile()) != null) {
        if (search.getName().equals(path.getName())) {
            return true;
        }
    }
    return false;
}