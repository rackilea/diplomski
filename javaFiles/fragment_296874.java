public View getViewAtPosition(int position) {
    View view = null;
    switch(position) {
        case 0:
            view = view0;
            break;
        case 1:
            view = view1;
            break;
        case 2:
            view = view2;
            break;
        default:
            view = viewError;
    }
    return view;
}