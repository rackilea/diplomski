import java.nio.file.*;

public class PathChecker {

public static void main (String[] args) {
    try {
        Path relative = Paths.get("myFile.txt");
        Path absolute = Paths.get("//home//denis//workspace//ocp//myFile.txt");
        System.out.println("Relative path: " + relative + " -> root: " + relative.getRoot());
        System.out.println("Absolute path: " + absolute + " -> root: " + absolute.getRoot());
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}