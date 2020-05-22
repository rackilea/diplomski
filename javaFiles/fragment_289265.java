public void showListDialog(int title, String[] items, Drawable icon, DialogHelperListener callback) {
        new MaterialDialog.Builder(this.mCtx)
                .title(title)
                .items(items)
                .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice(){
                  @Override
                  public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                    callback.onSelection(dialog, view, which);
                  }
                })
                .positiveText("Select")
                .show();
}