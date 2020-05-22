private void initializeDependencyInjector() {

    DaggerFacebookComponent.builder()
            .facebookModule(new FacebookModule())
            .build().inject(this);
}