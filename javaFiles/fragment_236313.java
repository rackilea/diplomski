final Server server = new Server();
//skipped socketconnector initialization

final WebAppContext js = new WebAppContext();
js.setServer(server);
js.setContextPath("/js");
js.setWar("target/classes/js"); // or whatever the correct path is in your case
server.addHandler(js);

// css the same way

final WebAppContext bb = new WebAppContext();
bb.setServer(server);
bb.setContextPath("/");
bb.setWar("src/main/webapp");
server.addHandler(bb);

server.start();