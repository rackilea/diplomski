public class ViewModelString extends ViewModel {

    private MutableLiveData<String> mString = new MutableLiveData<>();

    public MutableLiveData<String> getmString() {
        return mString;
    }

    public void setmString(MutableLiveData<String> mString) {
        this.mString = mString;
    }

}