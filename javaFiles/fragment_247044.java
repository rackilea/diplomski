//Get the URL with method class.getResource("/path/to/image.png")
URL url = System.class.getResource("/images/Graph.png");

//Use it to get the image
Image img = Toolkit.getDefaultToolkit().getImage(url);

final TrayIcon trayIcon = new TrayIcon(img, "Application Name", popup);