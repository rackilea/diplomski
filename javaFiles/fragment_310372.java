public class ListFragment extends BaseFragment {

    @Inject ListFragmentPresenterImpl listFragmentPresenter;

    public static ListFragment newInstance(){
        ListFragment result = new ListFragment();
        return result;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainActivity)getActivity()).getComponent().injectFragment(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.list_fragment, container, false);
        Log.d("",listFragmentPresenter.sayHello());  // NPE HERE
        return rootView;
    }
}