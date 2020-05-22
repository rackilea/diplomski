package multicp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;

/**
 * Copy files using threads.
 */
public class Multicp {
    public static void main(String[] args) {
        // List of source/dest pairs ("tasks")
        List<CopierCallable<Void>> opsList = new ArrayList<>();
        opsList.add(new CopierCallable<>(Paths.get("f1src.dat"), Paths.get("f1dest.dat")));
        opsList.add(new CopierCallable<>(Paths.get("f2src.dat"), Paths.get("f2dest.dat")));
        opsList.add(new CopierCallable<>(Paths.get("f3src.dat"), Paths.get("f3dest.dat")));
        opsList.add(new CopierCallable<>(Paths.get("f4src.dat"), Paths.get("f4dest.dat")));

        ExecutorService execSvc = Executors.newFixedThreadPool(2); // 4 in your case. 2 is just for testing
        try {
            execSvc.invokeAll(opsList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            execSvc.shutdown();
        }
    }

}

/**
 * Performs actual copying from one source to one destination.
 */
class CopierCallable<Void> implements Callable<Void> {
    private Path pathFrom;
    private Path pathTo;

    public CopierCallable(Path pathFrom, Path pathTo) {
        this.pathFrom = pathFrom;
        this.pathTo = pathTo;
    }

    @Override
    public Void call() {
        try {
            // REPLACE_EXISTING is destructive, uncomment at your own risk
            Files.copy(pathFrom, pathTo, COPY_ATTRIBUTES /*, REPLACE_EXISTING*/);
            System.out.println(pathFrom + " copied");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}