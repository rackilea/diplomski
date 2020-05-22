@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQ_BUY_PRODUCT && resultCode == Activity.RESULT_OK) {
        // here you verify data intent and update your GUI
        ...
        return;
    }
}