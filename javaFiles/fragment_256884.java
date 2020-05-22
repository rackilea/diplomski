final MutableLiveData<Integer> val = new MutableLiveData<Integer>() {
    @Override
    public void setValue(Integer value) {
        Log.d(TAG, "setValue before");
        super.setValue(value);
        Log.d(TAG, "setValue after");
    }
};