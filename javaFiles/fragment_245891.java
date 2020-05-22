import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

import static java.nio.file.FileVisitResult.*;
import static java.nio.file.FileVisitOption.*;

import java.util.*;

public class Find {

    public static class Finder
        extends SimpleFileVisitor<Path> {

        private final PathMatcher matcher;
        private int numMatches = 0;

        Finder(String pattern) {
            matcher = FileSystems.getDefault()
                    .getPathMatcher("glob:" + pattern);
        }

        // Compares the glob pattern against
        // the file or directory name.
        void find(Path file) throws IOException {
            String path = file.toString();
            path = path.toUpperCase();
            if(!path.contains("D:\\users\\mg\\workspace\\bin".toUpperCase()) && !path.contains("D:\\users\\mg\\workspace\\build".toUpperCase())){

                    Path name = file.getFileName();
                try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ImageList.txt",true)))){

                    if ((name != null) && (matcher.matches(name))) {

                    numMatches++;
                    out.write(file.toString());
                    out.write("\r\n\r\n");
                    out.flush();
                    out.close();
                        System.out.println(file + "\n");
                    }


                }catch (IOException e){
                    //Exception handling placeholder
                }                 
            }

        }


        // Prints the total number of
        // matches to standard out.
        void done() {
            System.out.println("Matched: "
                + numMatches);
        }

        // Invoke the pattern matching
        // method on each file.
        @Override
        public FileVisitResult visitFile(Path file,
                BasicFileAttributes attrs) throws IOException {
            find(file);
            return CONTINUE;
        }

        // Invoke the pattern matching
        // method on each directory.
        @Override
        public FileVisitResult preVisitDirectory(Path dir,
                BasicFileAttributes attrs) throws IOException {
            find(dir);
            return CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file,
                IOException exc) {
            System.err.println(exc);
            return CONTINUE;
        }
    }

    static void usage() {
        System.err.println("java Find <path>" +
            " -name \"<glob_pattern>\"");
        System.exit(-1);
    }

    public static void main(String[] args)
        throws IOException {

        if (args.length < 3 || !args[1].equals("-name"))
            usage();

        Path startingDir = Paths.get(args[0]);
        String pattern = args[2];

        Finder finder = new Finder(pattern);
        Files.walkFileTree(startingDir, finder);
        finder.done();

    }
}