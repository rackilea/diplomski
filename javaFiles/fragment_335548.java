@Override
public void onBackPressed() {
    boolean wentBack = false;

    if (Fragment1.canGoBack()) {
        wentBack = true;
        Fragment1.goBack();
    }
    if (Fragment2.canGoBack()) {
        wentBack = true;
        Fragment2.goBack();
    }

    if (!wentBack) {
        new AlertDialog.Builder(this)
            .setTitle("Quit app?")
            .setMessage("Do you want to quit?")
            .setPositiveButton("Yes", (dialog, which) -> super.onBackPressed())
            .setNegativeButton("No", (dialog, which) -> {})
            .show();
    }
}