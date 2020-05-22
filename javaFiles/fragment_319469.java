package edu.proj.res;

public class Main {
    public static String getDatabaseLocation() {
        return Main.class.getClassLoader().getResource("edu/proj/res/database.txt").toString();
    }
    public static String changeToWindowsPath(String path) {
    return path.replace("file:/", "").replaceAll("/", "\\\\");
}
    public static void main(String[] args) {
        System.out.println(changeToWindowsPath(getDatabaseLocation()));
    }
}