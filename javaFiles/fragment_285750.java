public class ExampleViewModel extends ViewModel {
    private MutableLiveData<String> sortingMode = new MutableLiveData<>();

    public LiveData<String> getSortingMode() {
        return sortingMode;
    }

    public void setSortingMode(String mode) {
        sortingMode.postValue(mode);
    }
}