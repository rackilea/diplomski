Text text = new Text(shell, SWT.SINGLE);
text.addModifyListener(new ModifyListener() {

    @Override
    public void modifyText(ModifyEvent e) {
        Text source = (Text) e.getSource();
        System.out.println("text = " + source.getText());
    }
});
text.pack();