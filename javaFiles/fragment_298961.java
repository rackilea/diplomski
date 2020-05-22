@Override
public boolean performFinish() {
    IWizardContainer container = getContainer();
    if (summaryPage.equals(container.getCurrentPage())) {
        // Do something.
        return true;
    } else {
        container.showPage(summaryPage);
        return false;
    }
}