@Override
public void update() {
    if (!sender) {
        getSubView().setVisibility(View.GONE);
    }
    sender = false;
}