public static class DummyListFragment extends ListFragment {

public DummyListFragment() {
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    return inflater.inflate(R.layout.my_list_fragment, container, false);
}