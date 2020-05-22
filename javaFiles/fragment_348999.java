final String MAVEN_IMPORT_WIZARD_ID = 
    "org.eclipse.m2e.core.wizards.Maven2ImportWizard";

final IWizardDescriptor mavenImportWizardDescriptor = 
    PlatformUI
    .getWorkbench()
    .getImportWizardRegistry()
    .findWizard(MAVEN_IMPORT_WIZARD_ID);

if (mavenImportWizardDescriptor != null) {
    final IWizard mavenImportWizard = mavenImportWizardDescriptor.createWizard();
    final WizardDialog mavenImportWizardDialog = new WizardDialog(getShell(), mavenImportWizard);
    mavenImportWizardDialog.open();
}
else {
    // Wizard not found - e.g. if m2e is not installed. 
    // Notify user. 
}