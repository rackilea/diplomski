PasswordPolicyManagerProvider pwPolicyManager = session.getProvider(PasswordPolicyManagerProvider.class);
PolicyError err = pwPolicyManager.validate(user.getUsername(), cred.getValue());
if (err != null) {
  // log error here
  return false;
}