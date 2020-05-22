public class Fragment2 extends Fragment {

private ViewModelString viewModel;

public Fragment2() {
        // Required empty public constructor
    }

    public static Fragment2 newInstance() {
        return new Fragment2();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialize ViewModel here
        viewModel = ViewModelProviders.of(requireActivity()).get(ViewModelString.class);
    }

@Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

TextView textView = findViewById(R.id.yourTextViewId);

        // Gets the string
        viewModel.getmString().observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);

            }
        });

}
...
}