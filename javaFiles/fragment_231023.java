Logger simpleLogger = new Logger() {

        public void println(String string, Level level) {
            if (level == Level.WARNING) {
                p.print("! ");
            } else if (level == Level.ERROR) {
                p.print("!! ");
            }
            p.println(string);
        }

        public void close() {
            p.close();
        }
    };

RserverConf serverConf = new RserverConf(null, staticPortCounter++, null, null, null);
Rdaemon server = new Rdaemon(serverConf, this);
server.start(null);
rsession = Rsession.newInstanceTry(serverConf);