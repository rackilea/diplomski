@Module public class MainActivityModule {
  // I'm assuming this is actually activity scoped, but if it's truly singleton,
  // leave it @Singleton and move it to AppModule.
  @Provides
  @ActivityScope
  static Billing provideBilling(Context context) {
    return new Billing(context);
  }

  @Provides
  @ActivityScope
  static ActivityCheckout provideActivityCheckout(
      MainActivity activity, Billing billing) {
    return ActivityCheckout.forActivity(activity, billing);
  }
}