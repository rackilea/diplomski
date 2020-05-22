public void setMenuIconState(State state) {
    switch (state) {
        case READY:
            mMenu.findItem(R.id.action_next).setIcon(R.drawable.small_arrow_green);
            mReady = true;
            break;
        case WAITING:
            mMenu.findItem(R.id.action_next).setIcon(R.drawable.small_clock_gray);
            mReady = false;
            break;
        default:
            mReady = false;
    }
}