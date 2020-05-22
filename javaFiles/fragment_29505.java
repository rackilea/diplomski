IToolBarManager mgr = this.getViewSite().getActionBars().getToolBarManager();
IContributionItem comboCI = new ControlContribution("test") {
        protected Control createControl(Composite parent) {

            final Combo c = new Combo(parent, SWT.READ_ONLY);
            c.add("one");
            c.add("two");
            c.add("three");
            c.addSelectionListener(new SelectionAdapter() {
                 public void widgetSelected(SelectionEvent e) {
                     c.add("four");
                  }
                  });
            return c;
        }
    };        

    mgr.add(comboCI);
}