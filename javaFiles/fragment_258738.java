public class MyFirstWorkflowFactory implements WorkflowFactory {

    @Override
    public Workflow create() {
        final ShellAction shellAction = ShellActionBuilder.create()
                .withName("shell-action")
                .withResourceManager("${resourceManager}")
                .withNameNode("${nameNode}")
                .withConfigProperty("mapred.job.queue.name", "${queueName}")
                .withExecutable("echo")
                .withArgument("my_output=Hello Oozie")
                .withCaptureOutput(true)
                .build();

        final Workflow shellWorkflow = new WorkflowBuilder()
                .withName("shell-workflow")
                .withDagContainingNode(shellAction).build();

        return shellWorkflow;
    }
}