public class SamplePresenter implements ISamplePresenter {

    ISampleView view;

    public Presenter(ISampleView view){
        this.view = view;
    }

    @Override
    public void buttonClicked() {
        // check if user can go to next activity
        view.navigateToNextView();
    }
}