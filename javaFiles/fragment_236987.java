// Create server sockets.
fRequestServerSocket = new ServerSocket(REQUEST_PORT);
fRequestServerSocket.setSoTimeout(ACCEPT_TIMEOUT);
TWBLogger.logInfo("Open socket request server:" + fRequestServerSocket);

fEventServerSocket = new ServerSocket(EVENT_PORT);
fEventServerSocket.setSoTimeout(ACCEPT_TIMEOUT);
TWBLogger.logInfo("Open socket event server:" + fEventServerSocket);

// Serve up the Flash policy file.
serveFlashPolicy();

// Connect request socket.
fRequestSocket = fRequestServerSocket.accept();
TWBLogger.logInfo("Open socket request:" + fRequestSocket);

fRequestWriter = new PrintWriter(fRequestSocket.getOutputStream());
fRequestReader = new BufferedReader(new InputStreamReader(fRequestSocket.getInputStream()));

// Connect event socket.
fEventSocket = fEventServerSocket.accept();
TWBLogger.logInfo("Open socket event:" + fEventSocket);

fEventReader = new BufferedReader(new InputStreamReader(fEventSocket.getInputStream()));