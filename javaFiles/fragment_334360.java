// override the onDestroyView of the fragment
@Override
public void onDestroyView() {
    super.onDestroyView();
    MapFragment f = (MapFragment) getFragmentManager()
                                         .findFragmentById(R.id.the_map);
    if (f != null) 
        getFragmentManager().beginTransaction().remove(f).commit();
}