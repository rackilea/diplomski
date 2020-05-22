public static void showListDialog(int title, String[] items, Drawable icon, Context ctx, MaterialDialog.ListCallbackSingleChoice callback) {
  new MaterialDialog.Builder(ctx)
                .title(title)
                .items(items)
                .itemsCallbackSingleChoice(-1, callback)
                .positiveText("Select")
                .show();
}