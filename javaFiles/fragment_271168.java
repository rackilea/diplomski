private void calculate() {

    try {
        String height = etHeight.getText().toString();
        int nHeight = Integer.parseInt(height);
        String weight = etWeight.getText().toString();
        int nWeight = Integer.parseInt(weight);
        result = nWeight / (nHeight * nHeight);
        String textResult = "" + result;
        etBMI.setText(textResult);
    }
    catch (NumberFormatException e) {
        etBMI.setText("");
    }
}