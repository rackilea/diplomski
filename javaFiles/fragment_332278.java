@Nullable
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    getActivity().setTitle("Inbox");

    myView = inflater.inflate(R.layout.inbox_layout, container, false);

    ListView list = (ListView) myView.findViewById(R.id.listViewMyAccount);
    inboxCellElement[] elts = new inboxCellElement[] {new inboxCellElement(R.drawable.ic_menu_camera, "Val", "Hi !")};
    list.setAdapter(new inboxCellAdapter(getActivity(), R.layout.inbox_cell_layout, elts, (NavDrawer) getActivity()));

    return myView; 
}