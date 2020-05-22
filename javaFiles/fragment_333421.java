DesktopOptions desktopOption = new DesktopOptions();
desktopOption.setApplicationPath("Path_to_your_app.exe");
File drivePath = new File("C:\\temp\\Winium.Desktop.Driver.exe");
WiniumDriverService service = new WiniumDriverService.Builder().usingDriverExecutable(drivePath).usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();
service.start();
WiniumDriver winiumDriver = WiniumDriver(service, desktopOption);