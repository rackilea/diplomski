public static class SomePresenter {

    private SomeView view;

    public SomePresenter(SomeView view) {
        this.view = view;
        view.showProgressLoading();
        loadData();
    }

    private void loadData(){
        //loading data from some server
    }

    private void loadingDataHandler(SomeModel model){
        view.showData(model);
    }
}

public static class SomeView extends View{

    @Inject(R.id.text_progress_title) TextView text;

    public SomeView(Context context) {
        super(context);
        ButterKnife.inject(this);
    }

    public void showData(SomeModel model){
        text.setText(model.dataA + ":" +  model.dataB);
    }

    public void showProgressLoading(){
        text.setText(R.string.progress);
    }
}

public static class SomeModel{
    public final int dataA;
    public final int dataB;
}