private void clearArrayAdapterItemsWithPrompt(int spinnerId) {
    setArrayAdapterItemsWithSpinnerId(spinnerId, new ArrayList<String>())
}

private void setArrayAdapterItemsWithSpinnerId(int spinnerId, List<String> list) {
    switch (spinnerId) {
        case R.id.spinner_a:
            this.spinnerAdapterItemsA = list;
            break;
        case R.id.spinner_b:
            this.spinnerAdapterItemsB = list;
            break;
        case R.id.spinner_c:
            this.spinnerAdapterItemsC = list;
            break;
        default:
        break;
}