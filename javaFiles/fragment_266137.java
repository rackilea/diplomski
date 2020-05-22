readData(new MyCallback() {
    @Override
    public void onCallback(List<String> al) {
        for(String name : al) {
            Log.d("TAG", name);
        }
    }
})