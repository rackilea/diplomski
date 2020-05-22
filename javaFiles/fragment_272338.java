@Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        whenever(serverInteractor.get()).thenReturn("http://fakeurl")
        loginPresenter = LoginPresenter(
            view, strategy, navigator, tokenRepository, localRepository, settingsInteractor,
            analyticsManager, saveCurrentServer, saveAccountInteractor, factory, serverInteractor
        )
    }