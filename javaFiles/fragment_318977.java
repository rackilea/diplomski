@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    switch (requestCode) {
    case REQUSET_CODE_YOUR:
        if (resultCode == RESULT_OK) {
            // write here code via **RESULT_OK**
        }
        break;

    default: // none of these
        break;
    }
}