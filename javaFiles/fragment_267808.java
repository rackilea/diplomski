public class Profile extends Fragment {
    private List<String> titleList;
    private List<Fragment> fragmentList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //your code for views initialization

        //init the lists here!
        titleList = new ArrayList<>();
        fragmentList = new ArrayList<>();

        prepareDataResource();

        //your adapter set up code

        return view;
    }