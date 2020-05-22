public class NoticeViewModel extends AndroidViewModel {
    public MutableLiveData<List<Notice>> mNoticesLiveData = new MutableLiveData<>();

    private Context mContext;

    public NoticeViewModel(final Application application) {
        super(application);
        mContext = application.getApplicationContext();

        mNoticesLiveData = Transformations.switchMap(databaseCreated,
                (Function<Boolean, LiveData<List<Notice>>) isDbCreated -> {
                    if (!Boolean.TRUE.equals(isDbCreated)) { // Not needed here, but watch out for null
                        //noinspection unchecked
                        return ABSENT;
                    } else {
                            return databaseCreator.getDatabase()
                                    .noticedao()
                                    .getSavedNotices();
                        }
                    }
                });

    public LiveData<List<Notice> getNoticeLiveData() {
        return mNoticesLiveData;
    }
}