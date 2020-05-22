public enum StopCharTesters implements StopCharTester {
    COMMA_STOP {
        @Override
        public boolean isStopChar(int ch) {
            return ch < ' ' || ch == ',';
        }
    }, CONTROL_STOP {
        @Override
        public boolean isStopChar(int ch) {
            return ch < ' ';
        }
    },
    SPACE_STOP {
        @Override
        public boolean isStopChar(int ch) {
            return Character.isWhitespace(ch) || ch == 0;
        }
    },
    XML_TEXT {
        @Override
        public boolean isStopChar(int ch) {
            return ch == '"' || ch == '<' || ch == '>' || ch == 0;
        }
    },
    FIX_TEXT {
        @Override
        public boolean isStopChar(int ch) {
            return ch <= 1;
        }
    };