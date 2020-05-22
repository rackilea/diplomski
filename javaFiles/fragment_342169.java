@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).registerDataUpdateListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((MainActivity) getActivity()).unregisterDataUpdateListener(this);
    }