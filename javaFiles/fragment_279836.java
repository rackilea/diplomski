@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class EndProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment env) {
        super.init(env);
        Trees trees = Trees.instance(env);
        JavacTask.instance(env).addTaskListener(new TaskListener() {

            @Override
            public void started(TaskEvent taskEvent) {
                // Nothing to do on task started event.
            }

            @Override
            public void finished(TaskEvent taskEvent) {
                if(taskEvent.getKind() == ANALYZE) {
                    new MyTreeScanner(trees).scan(taskEvent.getCompilationUnit(), null);
                }
            }

        });
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // We don't care about this method, as it will never be invoked for our annotation.
        return false;
    }
}