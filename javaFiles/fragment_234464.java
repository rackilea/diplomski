@Override
    public void posClickedLong(short p) {
        adapter.setSelectedPosition(p);
    }

    @Override
    public void posClickedShort(short p) {
        adapter.setSelectedPosition(p);
    }

    @Override
    public void onBackPressed() {

    backPressed=true;
    if(longClickOk && itemsTempArray.size()>0){
       adapter.clearSelection();
    } else{
        super.onBackPressed();
    }
}