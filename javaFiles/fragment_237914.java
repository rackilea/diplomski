public class LatestTaskExecutor implements Executor {
    private final AtomicReference<Runnable> lastTask =new AtomicReference<>();
    private final Executor executor;

    public LatestTaskExecutor(Executor executor) {
        super();
        this.executor = executor;
    }

    @Override
    public void execute(Runnable command) {
        lastTask.set(command);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Runnable task=lastTask.getAndSet(null);
                if(task!=null){
                    task.run();
                }
            }
        });

    }
}

@RunWith( MockitoJUnitRunner.class )
public class LatestTaskExecutorTest {

    @Mock private Executor executor;
    private LatestTaskExecutor latestExecutor;
    @Before
    public void setup(){
        latestExecutor=new LatestTaskExecutor(executor);
    }
    @Test
    public void testRunSingleTask() {
        Runnable run=mock(Runnable.class);
        latestExecutor.execute(run);
        ArgumentCaptor<Runnable> captor=ArgumentCaptor.forClass(Runnable.class);
        verify(executor).execute(captor.capture());
        captor.getValue().run();
        verify(run).run();
    }

    @Test
    public void discardsIntermediateUpdates(){
        Runnable run=mock(Runnable.class);
        Runnable run2=mock(Runnable.class);
        latestExecutor.execute(run);
        latestExecutor.execute(run2);
        ArgumentCaptor<Runnable> captor=ArgumentCaptor.forClass(Runnable.class);
        verify(executor,times(2)).execute(captor.capture());
        for (Runnable runnable:captor.getAllValues()){
            runnable.run();
        }
        verify(run2).run();
        verifyNoMoreInteractions(run);
    }
}