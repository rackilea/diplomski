@Controller
public class QueueMonitorController {

    @Autowired
    private Executor executor;

    @RequestMapping(value = "/queuesize", method = RequestMethod.GET)
    public int queueSize() {
        ThreadPoolExecutor tpe = (ThreadPoolExecutor)executor;
        return tpe.getThreadPoolExecutor().getQueue().size();
    }
}