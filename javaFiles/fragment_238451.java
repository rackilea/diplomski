public class MyFragment extends Fragment {
    @Inject Provider<MyTask> myTaskProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(this);
        myTaskProvider.get().execute();
    }
}