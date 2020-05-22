public AdUtil {
  private AdUtil(){}

  ...

  // Here the parameter context can be Application, Activity, etc.
  public static AdView createAdView(Context context) {
    AdView adView = new AdView(context);

    ...
    return adView;
  }
}