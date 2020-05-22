@GET
public SecretPlan getSecretPlan(@Auth Subject subject) {
  if (user.hasRole("secretPlanner")) {
    return new SecretPlan();
  } else {
    return new NonSecretPlan();
  }
}