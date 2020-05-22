@Component
@Profile("local")
public class LocalExampleService implements ExampleService{}

@Component
@Profile("remote")
public class RemoteExampleService implements ExampleService{}