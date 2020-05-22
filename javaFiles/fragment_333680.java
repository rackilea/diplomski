@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View list_root = inflater.inflate(R.layout.fragment_list, null);
      // Get the list header - to be added later in the lifecycle
      // during onActivityCreated()
      mheaderView = inflater.inflate(R.layout.my_list_header, null);
      return list_root;

    }


@Override
public void onActivityCreated(Bundle savedInstanceState) {
     super.onActivityCreated(savedInstanceState);
     if (mheaderView != null)  this.getListView().addHeaderView(headerView);
     // Don't forget to now call setListAdapter()
     this.setListAdapter(listAdapter);
}

@Override
public void onDestroyView()
{
    super.onDestroyView();

    // free adapter
    setListAdapter(null);
}