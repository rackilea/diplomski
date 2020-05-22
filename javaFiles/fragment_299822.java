public class MainPresenterImpl implements MainViewPresenter {
  // ... other fields ...
  @Inject
  ListingInteractor interactor;

  public MainPresenterImpl(MainActivity activity) {
    this.context = activity;
    this.mainView = activity;
  }
}