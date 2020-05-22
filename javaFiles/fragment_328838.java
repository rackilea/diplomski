public interface MyView extends IsWidget {

    public interface Presenter {
        void onLoginButtonClicked();
    }

    void setPresenter(Presenter listener);
}