SimpleAdapter.ViewBinder viewBinder = new SimpleAdapter.ViewBinder() {
    @Override
    public boolean setViewValue(View view, Object data, String textRep) {
        if (view.getId() == R.id.tv_h_name) {
            ((TextView)view).setText((String)data);
            return true;
        } else if (view.getId() == R.id.tv_h_rent) {
            // same here
        } else if (view.getId() == R.id.iv_h_frontPic) {
            ((ImageView)view).setImageBitmap((Bitmap)data);
            return true;
        }
        return false;
    }
}
((SimpleAdapter)adapter).setViewBinder(viewBinder);