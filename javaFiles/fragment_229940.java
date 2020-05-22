@Override
public void onBackPressed() {
    if (view.canGoBack()) {
        view.goBack();
    } else {
        super.onBackPressed();
    }
}