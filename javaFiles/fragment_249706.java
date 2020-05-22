public class ProgressInputStream extends InputStream {

public ProgressInputStream(String name, InputStream inputStream, long size) {
this.size = size;
this.inputStream = inputStream;
this.name = name;
 }

public ProgressInputStream(String name, FileContent content)
throws FileSystemException {
this.size = content.getSize();
this.name = name;
this.inputStream = content.getInputStream();
 }

@Override
public void close() throws IOException {
super.close();
if (closed) throw new IOException("already closed");
closed = true;
 }

@Override
public int read() throws IOException {
int count = inputStream.read();

    progress ++;
lastUpdate = maybeUpdateDisplay(name, progress, lastUpdate, size);

 return count;
}
/*@Override
public int read(byte[] b, int off, int len) throws IOException {
int count = inputStream.read(b, off, len);

progress ++;
lastUpdate = maybeUpdateDisplay(name, progress, lastUpdate, size);
System.out.println("count"+count+"size"+size);

return count;

}*/


static long maybeUpdateDisplay(String name, long progress, long lastUpdate, long size)     {
  /* if (Config.isInUnitTests()) return lastUpdate;
  if (size < B_IN_MB/10) return lastUpdate;
  if (progress - lastUpdate > 1024 * 10) {
    lastUpdate = progress;
    int hashes = (int) (((double)progress / (double)size) * 40);
    if (hashes > 40) hashes = 40;
    String bar = StringUtils.repeat("#",
            hashes);
    bar = StringUtils.rightPad(bar, 40);
    System.out.format("%s [%s] %.2fMB/%.2fMB\r",
            name, bar, progress / B_IN_MB, size / B_IN_MB);
    System.out.flush();
  }*/


 System.out.println("name "+ name+"  progress "+ progress+" lastUpdate "+ lastUpdate+"      "+ "sie "+ size);
return lastUpdate;
}}