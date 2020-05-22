public ListBoxModel doFillAuthTokenCredentialIdItems() {
  final ListBoxModel lbm = new ListBoxModel();
  final Jenkins jenkins = Jenkins.getInstance();

  if (jenkins == null) {
    return lbm;
  }

  if (!jenkins.hasPermission(Jenkins.ADMINISTER)) {
    return lbm;
  }
  AbstractIdCredentialsListBoxModel model = new StandardListBoxModel().includeEmptyValue().includeAs(ACL.SYSTEM, jenkins, VaultTokenCredential.class);
  return model;
}