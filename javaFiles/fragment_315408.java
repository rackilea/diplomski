public class CassUtil {
    ...
    private volatile State state = new State(
        new ArrayList<>(), new ArrayList<>(), new ArrayList<>()
    );
    ...
    public void startScheduleTask() {
        ...
                    this.state = new State(
                        processMetadata(true), listOfTopic(TestUtils.GROUP_ID), 
                        procMetadata()
                    );
        ...
    }
    ...
    public void initializeMetadata() {
        this.state = new State(
            processMetadata(true), listOfTopic(TestUtils.GROUP_ID), procMetadata()
        );
        startScheduleTask();
    }
    ...

    public List<ProcessMetadata> getProcessMetadata() {
        return this.state.getProcessMetadata();
    }

    public List<String> getTopicMetadata() {
        return this.state.getTopicMetadata();
    }

    public List<ProcMetadata> getProcMetadata() {
        return this.state.getProcMetadata();
    }