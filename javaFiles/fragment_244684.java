public class buttonsComp extends Composite implements SomethingHappenedListener{

    public buttonsComp(Composite parent, int style) {
        super(parent, style);
        setLayout(new FillLayout(SWT.HORIZONTAL));
        Button btnNewButton = new Button(this, SWT.NONE);
        btnNewButton.setText("New Button");
        Button btnAsd = new Button(this, SWT.NONE);
        btnAsd.setText("asd");
    }

    @Override
    protected void checkSubclass() {

    }

    public void somethingHappened(SomethingHappenedEvent e)
    {
        //do stuff....
    }
}