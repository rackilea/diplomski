Game myGame = new Game(); // your game class which implements ApplicationListener

AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
cfg.useGL20 = true;
cfg.useCompass = false;
cfg.useAccelerometer = false;
cfg.useWakelock = true;
cfg.touchSleepTime = 16;

initialize(myGame, cfg);