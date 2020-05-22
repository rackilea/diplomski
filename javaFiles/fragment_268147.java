@Provides
@Singleton  // BAD: If this is Singleton, it will outlive and leak MainActivity.
            // Dagger will complain about mismatched scopes, but it's right:
            // It doesn't make sense for ActivityCheckout to be @Singleton.
static ActivityCheckout provideActivityCheckout(
    MainActivity activity, Billing billing) {
  return ActivityCheckout.forActivity(activity, billing);
}