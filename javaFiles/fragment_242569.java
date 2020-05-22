import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Service<T> {

    private final ConcurrentMap<String, Object> locks = new ConcurrentHashMap<>();
    public final ExecutorService exec = Executors.newFixedThreadPool(5);

    public Future<Boolean> foo(T o,
                               final String fileName) throws IOException {
        return exec.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws IOException {
                File f = new File(fileName);

                synchronized (getCacheSyncObject(fileName)) {
                    try (OutputStream out = new FileOutputStream(f)) {
                        out.write("hi".getBytes());
                    }
                }

                return true;
            }
        });
    }

    private Object getCacheSyncObject(final String name) {
        Object result = locks.get(name);

        if (result == null) {
            result = new Object();
            Object prevLock;
            if ((prevLock = locks.putIfAbsent(name, result)) != null) {
                result = prevLock;
            }
        }

        return result;
    }
}

public class Test {

    public static void main(String[] args) throws Exception {
        Object obj = new Object();

        Service<Object> service = new Service<>();
        Future<Boolean> result1 = service.foo(obj, "filename");
        service.exec.shutdown();

        System.out.println("result1 = " + result1.get());
    }
}