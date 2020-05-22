public class Blah extends AppCompatActivity {

    private EditText passwordTxt;

    private Disposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        disposable = RxTextView.textChanges(passwordTxt)
                .debounce(400, TimeUnit.MILLISECONDS)
                .map(this::isValidPassword)
                .subscribeOn(Schedulers.io()) // Or Schedulers.newThread()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<Boolean>() {
                            @Override
                            public void accept(Boolean aBoolean) throws Exception {
                                // onNext
                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                // onError
                            }
                        },
                        new Action() {
                            @Override
                            public void run() throws Exception {
                                // onComplete
                            }
                        },
                        new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                // onSubscribe
                            }
                        }
                );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    private Boolean isValidPassword(CharSequence value) {
        return value.toString().matches("^(?=.*\\d).{4,8}$");
    }

}