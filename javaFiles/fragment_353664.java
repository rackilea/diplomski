@Singleton
public class RealWorkWindow implements WorkWindow {

  private final WorkWindow defaultWindow;
  private final WorkWindow workWindow;

  @Inject
  public RealWorkWindow(Factory myFactory, @Assisted LongSupplier longSupplier) {
    defaultWindow = myFactory.create(() -> 1000L);
    workWindow = myFactory.create(longSupplier);
  }

}