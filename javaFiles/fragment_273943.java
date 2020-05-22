public class FragmentOne extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)    {
      View  view = inflater.inflate(R.layout.fragment_one, container, false);
        return view;
    }
}