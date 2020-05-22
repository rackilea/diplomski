package de.scrum_master.app;

import difflib.DiffUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.*;

public class FileChangeWatcher {
    public static final String DEFAULT_WATCH_DIR = "watch-dir";
    public static final String DEFAULT_SHADOW_DIR = "shadow-dir";
    public static final int DEFAULT_WATCH_INTERVAL = 5;

    private Path watchDir;
    private Path shadowDir;
    private int watchInterval;
    private WatchService watchService;

    public FileChangeWatcher(Path watchDir, Path shadowDir, int watchInterval) throws IOException {
        this.watchDir = watchDir;
        this.shadowDir = shadowDir;
        this.watchInterval = watchInterval;
        watchService = FileSystems.getDefault().newWatchService();
    }

    public void run() throws InterruptedException, IOException {
        prepareShadowDir();
        watchDir.register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
        while (true) {
            WatchKey watchKey = watchService.take();
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                Path oldFile = shadowDir.resolve((Path) event.context());
                Path newFile = watchDir.resolve((Path) event.context());
                List<String> oldContent;
                List<String> newContent;
                WatchEvent.Kind<?> eventType = event.kind();
                if (!(Files.isDirectory(newFile) || Files.isDirectory(oldFile))) {
                    if (eventType == ENTRY_CREATE) {
                        if (!Files.isDirectory(newFile))
                            Files.createFile(oldFile);
                    } else if (eventType == ENTRY_MODIFY) {
                        Thread.sleep(200);
                        oldContent = fileToLines(oldFile);
                        newContent = fileToLines(newFile);
                        printUnifiedDiff(newFile, oldFile, oldContent, newContent);
                        try {
                            Files.copy(newFile, oldFile, StandardCopyOption.REPLACE_EXISTING);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (eventType == ENTRY_DELETE) {
                        try {
                            oldContent = fileToLines(oldFile);
                            newContent = new LinkedList<>();
                            printUnifiedDiff(newFile, oldFile, oldContent, newContent);
                            Files.deleteIfExists(oldFile);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            watchKey.reset();
            Thread.sleep(1000 * watchInterval);
        }
    }

    private void prepareShadowDir() throws IOException {
        recursiveDeleteDir(shadowDir);
        Runtime.getRuntime().addShutdownHook(
            new Thread() {
                @Override
                public void run() {
                    try {
                        System.out.println("Cleaning up shadow directory " + shadowDir);
                        recursiveDeleteDir(shadowDir);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        );
        recursiveCopyDir(watchDir, shadowDir);
    }

    public static void recursiveDeleteDir(Path directory) throws IOException {
        if (!directory.toFile().exists())
            return;
        Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void recursiveCopyDir(final Path sourceDir, final Path targetDir) throws IOException {
        Files.walkFileTree(sourceDir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.copy(file, Paths.get(file.toString().replace(sourceDir.toString(), targetDir.toString())));
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                Files.createDirectories(Paths.get(dir.toString().replace(sourceDir.toString(), targetDir.toString())));
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static List<String> fileToLines(Path path) throws IOException {
        List<String> lines = new LinkedList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            while ((line = reader.readLine()) != null)
                lines.add(line);
        }
        catch (Exception e) {}
        return lines;
    }

    private static void printUnifiedDiff(Path oldPath, Path newPath, List<String> oldContent, List<String> newContent) {
        List<String> diffLines = DiffUtils.generateUnifiedDiff(
            newPath.toString(),
            oldPath.toString(),
            oldContent,
            DiffUtils.diff(oldContent, newContent),
            3
        );
        System.out.println();
        for (String diffLine : diffLines)
            System.out.println(diffLine);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        String watchDirName = args.length > 0 ? args[0] : DEFAULT_WATCH_DIR;
        String shadowDirName = args.length > 1 ? args[1] : DEFAULT_SHADOW_DIR;
        int watchInterval = args.length > 2 ? Integer.getInteger(args[2]) : DEFAULT_WATCH_INTERVAL;
        new FileChangeWatcher(Paths.get(watchDirName), Paths.get(shadowDirName), watchInterval).run();
    }
}