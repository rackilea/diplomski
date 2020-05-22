public class ScrollFragment extends Fragment {

    private ObservableScrollView mScrollView;
    private String mString;

    public static ScrollFragment newInstance(String string) {
        ScrollFragment scrollFragment = new ScrollFragment();

        Bundle args = new Bundle();
        args.putString("stringKey", string);
        scrollFragment.setArguments(args);

        return scrollFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mString = getArguments().getString("stringKey");
    }

...
}