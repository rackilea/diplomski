public class LessThanLevelFilter implements Filter {

        private final int lvl;

        public LessThanLevelFilter() {
            String p = getClass().getName();
            String v = LogManager.getLogManager().getProperty(p + ".level");
            if (v != null) {
                lvl = Level.parse(v).intValue();
            } else {
                lvl = Level.WARNING.intValue();
            }
        }

        public LessThanLevelFilter(Level l) {
            lvl = l.intValue();
        }

        @Override
        public boolean isLoggable(LogRecord record) {
            return record.getLevel().intValue() < lvl;
        }
    }