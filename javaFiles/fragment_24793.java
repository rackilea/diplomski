class Foo extends Composite
{
    Combo name;
    Combo desc;

    public void tarriffAddWindow(final Shell childWindow)
    {
        // ...
        name.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e)
                desc.select(name.getSelectionIndex());
            }
        });
    }
}