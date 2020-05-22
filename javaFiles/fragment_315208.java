public class SingletonNameViewModelFactory extends ViewModelProvider.NewInstanceFactory {


    NameViewModel t;

    public SingletonNameViewModelFactory() {
      //  t = provideNameViewModelSomeHowUsingDependencyInjection
    }

    @Override
    public NameViewModel create(Class<NameViewModel> modelClass) {
        return t;
    }
}