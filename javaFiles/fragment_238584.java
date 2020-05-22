public class ConfigHandler extends Handler {

        private FileHandler fh;
        private ConsoleHandler ch;

        public ConfigHandler() {
            String p = getClass().getName();
            LogManager m = LogManager.getLogManager();
            try {
                String s = m.getProperty(p + ".level");
                if (s != null) {
                    super.setLevel(Level.parse(s));
                }                
            } catch (RuntimeException re) {
                super.reportError("", re, ErrorManager.OPEN_FAILURE);
            }
        }

        @Override
        public synchronized void publish(LogRecord record) {
            try {
                init(record);
            } catch (RuntimeException re) {
                reportError(null, re, ErrorManager.WRITE_FAILURE);
            } catch (Exception e) {
                reportError(null, e, ErrorManager.WRITE_FAILURE);
            }

            Handler h = this.ch;
            if (h != null) {
                h.publish(record);
            }

            h = this.fh;
            if (h != null) {
                h.publish(record);
            }
        }

        @Override
        public synchronized void flush() {
            Handler h = this.ch;
            if (h != null) {
                h.flush();
            }

            h = this.fh;
            if (h != null) {
                h.flush();
            }
        }

        @Override
        public synchronized void close() throws SecurityException {
            super.setLevel(Level.OFF);
            Handler h = this.ch;
            if (h != null) {
                h.close();
            }

            h = this.fh;
            if (h != null) {
                h.close();
            }
        }

        private boolean allowConsole(LogRecord r) {
            return isLoggable(r);
        }

        private boolean allowFile(LogRecord r) {
            return isLoggable(r);
        }

        private void init(LogRecord r) throws IOException {
            assert Thread.holdsLock(this) : this;
            if (ch != null && fh != null) {
                return;
            }

            Properties prop = new Properties();
            InputStream in = ConfigHandler.class.getResourceAsStream("loggconfig");
            if (in != null) {
                prop.load(in);
            } else {
                throw new FileNotFoundException("property file '" + in + "' not found in the classpath");
            }

            int saveMethod = Integer.parseInt(prop.getProperty("Savemethod"));

            if (saveMethod == 1) {
                if (ch == null && allowConsole(r)) {
                    ch = new ConsoleHandler();
                    ch.setLevel(Level.ALL);
                    ch.setFormatter(new SimpleFormatter());
                }
            } //Creates and Names the logg file to current date
            else if (saveMethod == 2) {
                try {
                    if (fh == null && allowFile(r)) {
                        Date date = new Date();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
                        fh = new FileHandler((dateFormat.format(date) + ".log"), false);
                        fh.setFormatter(new SimpleFormatter());
                    }
                    Logger l = Logger.getLogger(""); //???
                    l.setLevel(Level.parse(prop.getProperty("Level")));

                } catch (Exception e) {
                    reportError(null, e, ErrorManager.WRITE_FAILURE);
                }
            }
        }
    }