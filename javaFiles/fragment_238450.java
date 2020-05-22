/**
   * The application module.
   *
   * @param context The context.
   */
  public MyModule(final Context context) {
    this.context = context.getApplicationContext();
  }

  /**
   * Provides context.
   *
   * @return the application context.
   */
  @Provides @Singleton Context provideContext() {
    return context;
  }