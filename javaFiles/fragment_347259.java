View playScreen = new PlayScreen(this);
View container = new FrameLayout(this);

playScreen.setRootView(container);

container.addView(playScreen);
setContentView(container);