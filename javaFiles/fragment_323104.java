public interface MoviesContract {
    interface Presenter extends MvpPresenter<MoviesContract.View> {
        void loadMovies();
    }

    interface View extends MvpView {
        void onMoviesLoaded();
    }
}

public class MoviesPresenter extends BasePresenter<MoviesContract.View>
    implements MoviesContract.Presenter {

    @Override
    public void loadMovies() {
        getView.onMoviesLoaded();
    }
}


public class MoviesFragment extends BaseFragment<MoviesContract.View, MoviesContract.Presenter>
    implements MoviesContract.View {

    @Override
    public MoviesContract.View getThis() {
        return this;
    }

    public loadMovies() {
        getPresenter().loadMovies();
    }

    @Override
    public void onMoviesLoaded() {
        //
    }
}