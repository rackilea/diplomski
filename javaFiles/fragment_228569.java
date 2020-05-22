private void createSectionWithButton(FormToolkit toolkit, final Composite body, final GridData layoutData) {
    final Section section = createSection(toolkit, body, "Section", layoutData.grabExcessVerticalSpace);
    section.setLayoutData(layoutData);
    section.setClient(toolkit.createButton(section, "button", SWT.NONE));
}

private Section createSection(final FormToolkit toolkit, final Composite body, String title,
        boolean shouldGiveUpVerticalSpaceWhenFolded) {
    final Section section = toolkit.createSection(body, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
    section.setText(title);
    managedForm.addPart(new SectionPart(section));
    if (shouldGiveUpVerticalSpaceWhenFolded) {
        section.addExpansionListener(new ExpansionAdapter() {
            public void expansionStateChanged(ExpansionEvent e) {
                GridData gridData = (GridData) section.getLayoutData();
                gridData.grabExcessVerticalSpace = e.getState();
            }
        });
    }
    section.addExpansionListener(new ExpansionAdapter() {
        public void expansionStateChanged(ExpansionEvent e) {
            managedForm.reflow(true);
        }
    });
    return section;
}