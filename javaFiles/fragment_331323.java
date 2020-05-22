class ThreadCPUCompare implements Comparator<Long>
{
    private ThreadMXBean mxbean;

    @Override
    public int compare(Long threadId1, Long threadId2) {
        return Long.compare(mxbean.getThreadCpuTime(threadId2), mxbean.getThreadCpuTime(threadId1));
    }
}

@RunWith(MockitoJUnitRunner.class)
public class ThreadStatsTest
{
    @Mock ThreadMXBean mxbean;
    @InjectMocks Comparator comperator = new ThreadCPUCompare();

    @Test
    public void threadCPUSortTest() {
        // do your tests exactly as before
    }
}