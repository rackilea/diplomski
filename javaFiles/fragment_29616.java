public class Activity implements ActivityView {
    ...
    private Presenter mPresenter;

    public void onCreate() {
         // some other code

         mPresenter = new Presenter(this);

         // some other code
    }