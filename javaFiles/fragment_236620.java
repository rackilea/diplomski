AdFrame ff1 = new AdFrame();
ff1.setUndecorated(true);
ff1.setExtendedState(JFrame.MAXIMIZED_BOTH);
ff1.setVisible(true);
ff1.thispc = ff1.getGraphicsConfiguration().getDevice();
ff1.thispc.setFullScreenWindow(ff1);