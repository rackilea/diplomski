public final class TaskTransfer extends SimpleObjectTransfer {

public static final TaskTransfer INSTANCE = new TaskTransfer();

private TaskTransfer() {
}

@Override
protected String getTypeNamePrefix() {
    return "TASK_TRANSFER_FORMAT";
}
}