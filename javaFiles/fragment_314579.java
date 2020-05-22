public class ATest {
    static class TLogEntry {

        private long sessionId;
        private int logLevel;
        private int securityLevel;
        private long posixTimestamp;
        private CharSequence message;

        public long getSessionId() {
            return sessionId;
        }

        public void setSessionId(long sessionId) {
            this.sessionId = sessionId;
        }

        public int getLogLevel() {
            return logLevel;
        }

        public void setLogLevel(int logLevel) {
            this.logLevel = logLevel;
        }

        public int getSecurityLevel() {
            return securityLevel;
        }

        public void setSecurityLevel(int securityLevel) {
            this.securityLevel = securityLevel;
        }

        public long getPosixTimestamp() {
            return posixTimestamp;
        }

        public void setPosixTimestamp(long posixTimestamp) {
            this.posixTimestamp = posixTimestamp;
        }

        public CharSequence getMessage() {
            return message;
        }

        public void setMessage(CharSequence message) {
            this.message = message;
        }
    }

    static class LogEntryOutput implements WriteBytesMarshallable {
        private final int maxMessageSize;
        private TLogEntry logEntry;

        LogEntryOutput(final int maxMessageSize) {
            this.maxMessageSize = maxMessageSize;
        }

        public void setMarshallable(final TLogEntry logEntry) {
            this.logEntry = logEntry;
        }

        @Override
        @SuppressWarnings({"rawtypes", "No way to provide generic type and override WriteBytesMarshallable."})
        public void writeMarshallable(final BytesOut bytes) {
            bytes.writeLong(this.logEntry.getSessionId());
            bytes.writeInt(this.logEntry.getLogLevel());
            bytes.writeInt(this.logEntry.getSecurityLevel());
            bytes.writeLong(this.logEntry.getPosixTimestamp());

            // Limit size of string messages.
            final int messageSize = Math.min(this.logEntry.getMessage().length(), this.maxMessageSize);

            // Write message length
            bytes.writeStopBit((long) messageSize);

            // Write message bytes.
            bytes.write(this.logEntry.getMessage(), 0, messageSize);
        }
    }

    @Test
    public void test() {
        final TLogEntry entry = new TLogEntry();
        entry.setSessionId(321234L);
        entry.setLogLevel(77);
        entry.setSecurityLevel(1234);
        entry.setPosixTimestamp(6141234321L);
        entry.setMessage("This is a test message for the system................................ A");

        final LogEntryOutput output = new LogEntryOutput(1024);
        output.setMarshallable(entry);

        final ChronicleQueue queue = SingleChronicleQueueBuilder.binary(
                OS.TARGET + "/test-" + System.nanoTime())
                .rollCycle(RollCycles.HOURLY)
                .build();
        final ExcerptAppender appender = queue.acquireAppender();
        Jvm.setExceptionHandlers(Slf4jExceptionHandler.FATAL, Slf4jExceptionHandler.WARN, Slf4jExceptionHandler.WARN);
        for (int j = 0; j < 1000; ++j) {
            for (int i = 0; i < 10000; ++i) {
                appender.writeBytes(output);
            }

            System.out.println((j + 1) * 10000);
            // Jvm.pause(100L);
        }

        queue.close();
    }
}