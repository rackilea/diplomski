@Override
public Object instantiateItem(ViewGroup container, int position) {
    LayoutInflater inflater = getActivity().getLayoutInflater();
    View instView = getViewAtPosition(position);
    instView.setTag("layoutThingy"+position);
    container.addView(instView);
    instView.requestFocus();
    return instView;
}