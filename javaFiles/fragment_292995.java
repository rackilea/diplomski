import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public interface WorkerBindingModule {
    @Binds
    @IntoMap
    @WorkerKey(SimpleWorker.class)
    ChildWorkerFactory bindHelloWorldWorker(SimpleWorker.Factory factory);
}