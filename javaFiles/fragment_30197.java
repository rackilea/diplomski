button.setEnabled(false);
    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            button.setEnabled(false);
        }
    });

    text.addListener(SWT.FocusIn, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            button.setEnabled(true);
        }
    });