private View view0 = null;
private View view1 = null;
private View view2 = null;
private View viewError = null;

public TestAdapter(LayoutInflater inflater) {
    view0 = inflater.inflate(R.layout.fragment_generalsettingsinputdialog1, null);
    view1 = inflater.inflate(R.layout.fragment_generalsettingsinputdialog2, null);
    view2 = inflater.inflate(R.layout.fragment_generalsettingsinputdialog3, null);
    viewError = inflater.inflate(R.layout.fragment_viewpagererror, null);
}