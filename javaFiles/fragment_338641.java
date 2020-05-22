btnStartConversion.addSelectionListener(new SelectionAdapter() {
    @Override
    public void widgetSelected(SelectionEvent e) {
        //call conversion.
        try {
            System.out.println(OuterClass.this.inputFile.getText());
            System.out.println(OuterClass.this.outputFile.getText());
            @SuppressWarnings("unused")
            Convert convert = new Convert(OuterClass.this.inputFile.getText(),
                                          OuterClass.this.outputFile.getText());
        } catch (IOException | JSONException | InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
});