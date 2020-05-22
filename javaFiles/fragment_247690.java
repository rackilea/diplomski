pullData.getData(USERNAME, "3", new Pullcallback() {
    @Override
    public void getSingleData(String data) {
        imageGetter = new ImageGetter(data);
        imageList.add(imageGetter);
        imageAdapter.notifyDataSetChanged();
    }

    @Override
    public void getMultipleData(String[] multipledatas) {

    }

    @Override
    public void onError(String errormessage) {

    }
});