public class Fragment1 extends Fragment {

    View view;
    DrawerAdapter drawerAdapterObject;
    GridView drawerGrid;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.activity_apps,container,false);
        drawerGrid = (GridView) view.findViewById(R.id.content);
        drawerGrid.setAdapter(drawerAdapterObject);
        return view;
    }

}