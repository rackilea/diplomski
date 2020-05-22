@Singleton
@Component(modules = {AppModule.class, WorkerBindingModule.class})
public interface AppComponent {
    // Some other injects here
    SimpleWorkerFactory factory();
}