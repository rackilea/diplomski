class DemoApplicationWithAdvice extends DemoApplication {
    @Override
    protected void scheduledTask() {
        // record start time
        super.scheduledTask();
        // write metric with execution time
    }
}