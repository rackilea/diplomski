import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/work")
public class WorkController {

    private final WorkService service;
    private final ExecutorService executor;
    private List<Future<?>> futureList;

    public WorkController(WorkService service, ExecutorService executor) {
        this.service = service;
        this.executor = executor;
        this.futureList = new ArrayList<>();
    }

    @PostMapping(value = "/start", consumes = "application/json")
    public String startWorks(@RequestBody List<Long> workIds) {
        // create runnables based on work ids
        Collection<Runnable> workerList = new ArrayList<>();
        for (Long workId : workIds) {
            Runnable worker = service.createWorkRunnable(workId);
            workerList.add(worker);
        }

        for (Runnable worker : workerList) {
            Future<?> future = executor.submit(worker);
            futureList.add(future);
        }

        return "Finished all threads";
    }

    @PostMapping("/stop")
    public String stopWorks() {
        for (Future<?> f : futureList) {
            f.cancel(true);
        }
        return "Stopped";
    }
}