public interface InputFileItemStream implements Closeable {

     File read();
     void close();
     void reset();
     ...
}