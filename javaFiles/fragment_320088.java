public OpenFileDialog(Context context) {
    super(context);
    isOnlyFoldersFilter = false;
    title = createTitle(context);
    changeTitle();
    LinearLayout linearLayout = createMainLayout(context);
    linearLayout.addView(createBackItem(context));
    listView = createListView(context);
    linearLayout.addView(listView);
    setCustomTitle(title)
            .setView(linearLayout)
            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (selectedIndex > -1 && listener != null) {
                        listener.OnSelectedFile(listView.getItemAtPosition(selectedIndex).toString());
                        Log.i("OpenFileDialog", "selected: " + files.get(selectedIndex).getAbsolutePath());
                    }
                    if (listener != null && isOnlyFoldersFilter) {
                        listener.OnSelectedFile(currentPath);
                    }
                }
            })
            .setNegativeButton(android.R.string.cancel, null);
}   }