public class DataActivity extends AppCompatActivity {

    private DataViewModel mViewModel;
    private DataActivityBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.mViewModel = new DataViewModel();
        this.mBinding = DataBindingUtil.setContentView(this, R.layout.data_activity);
        this.mBinding.setViewModel(this.mViewModel);
    }
}