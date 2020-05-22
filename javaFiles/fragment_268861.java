public class ClientModule extends PrivateModule {
  private final Writer writer;
  private final Class<? extends Annotation> annotationType;

  public ClientModule(Writer writer, Class<? extends Annotation> annotationType) {
    this.writer = writer;
    this.annotationType = annotationType;
  }

  @Override protected void configure() {
    bind(Writer.class).toInstance(writer);
    bind(Logger.class).to(LoggerImpl.class);
    expose(Client.class).annotatedWith(annotationType);
  }
}

public class ClientFactoryModule extends AbstractModule {
  private final File file;

  public ClientFactoryModule(File file) {
    this.file = file;
  }

  @Override protected void configure() {
    install(new ClientModule(new StdOutWriter(), StdOut.class));
    install(new ClientModule(new FileWriter(file), FileOut.class));
    bind(ClientFactory.class).to(ClientFactoryImpl.class);
  }
}

public class ClientFactoryImpl implements ClientFactory {
  private final Client stdOutClient;
  private final Client fileClient;

  @Inject public ClientFactoryImpl(@StdOut Client stdOutClient, 
                                   @FileOut Client fileClient) {
    this.stdOutClient = stdOutClient;
    this.fileClient = fileClient;
  }

  ...
}