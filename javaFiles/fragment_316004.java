public class InferCallerFilter implements Filter {

        public boolean isLoggable(LogRecord record) {
            record.getSourceMethodName(); //Infer caller.
            return true;
        }
    }