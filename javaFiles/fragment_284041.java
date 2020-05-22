@Override
public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
    View mapView = super.onCreateView(inflater, viewGroup, bundle);
    RelativeLayout view = new RelativeLayout(getActivity());
    view.addView(mapView, new RelativeLayout.LayoutParams(-1, -1));
    // working with view
    return view;
}