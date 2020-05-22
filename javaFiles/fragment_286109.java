if (tField.getText() != null) {
    Object[] currentData = new Object[getFieldNum + 1];
    currentData[getFieldNum] = tField.getText();

    inputData[getFieldNum] = tField.getText();

    for (int i = 0; i < inputData.length; i++) {
        if (inputData[i] != null) {
            System.out.println("for i = " + i + ": " + inputData[i]);
        }

    }
}