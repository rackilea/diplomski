public static void main(String args[]) throws Exception {
    Path cwd = Paths.get("").toAbsolutePath();
    Path parentOfCwd = Paths.get("").toAbsolutePath().getParent();
    System.out.println(cwd.toAbsolutePath().toString() 
            + " in folder " + parentOfCwd.toAbsolutePath().toString());
}