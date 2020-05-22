public class Fragment1 extends Fragment {

private ViewModelString viewModel;

public Fragment1() {
        // Required empty public constructor
    }

    public static Fragment1 newInstance() {
        return new Fragment1();
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

String hello = "hello";

viewModel.setmString(hello);

}
}