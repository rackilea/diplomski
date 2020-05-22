public class GreatStuffActivity extends RoboActivity {
    private GreatStuffPresenter presenter;

    @Override
    public void onCreate(...) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_update_record);

        presenter = RoboGuice.getInjector(this).getInstance(GreatStuffPresenterFactory.class).create(this);
    }
}