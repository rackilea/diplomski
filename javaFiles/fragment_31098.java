Scale scale = new Scale(shell, SWT.BORDER);
scale.setMaximum(10 * 10);

Label speedLabel = new Label(shell, SWT.NONE);
speedLabel.setText("time");
scale.addListener(SWT.Selection, new Listener()
{
    public void handleEvent(Event event)
    {
        speedLabel.setText((scale.getSelection() / 10f) + "");
    }
});