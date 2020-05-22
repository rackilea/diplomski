public class ApplicationModule extends AbstractPresenterModule {
@Override
protected void configure() {
    install(new BuchAnalysisModule());

    bindPresenter(ApplicationPresenter.class,
                ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}