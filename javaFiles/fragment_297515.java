public class PutBuffer {
    public PutBuffer(ConnectionFactory connectionFactory) {…}
    public void setFlushTimeout(int millis) {…}
    public int getFlushTimeout() {…}
    public void addPut(TableName table, Put put) {…}
    public void discardBuffer(TableName table) {…}
    public void flush() {…}
}