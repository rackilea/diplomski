class fragment extends Fragments implements yourActivityClassName.DataReceivedListener {
    @Override
    void onReceived(int requestCode, int resultCode, Intent data) {

    }

    onViewCreated(...) {
        ((yourActivityName) getActivity()).setDataReceivedListener(this);
    }
}