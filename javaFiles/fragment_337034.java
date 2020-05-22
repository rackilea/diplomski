@Override
public void onDestroyView() {
    super.onDestroyView();
    MapFragment f = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
    if (f != null){ 
        getFragmentManager().beginTransaction().remove(f).commit();
    }
}