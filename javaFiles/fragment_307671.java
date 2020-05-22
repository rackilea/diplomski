import org.apache.commons.compress.utils.IOUtils

byte[] buf = new byte[(int) entry.getSize()];
int readed  = IOUtils.readFully(tarArchiveInputStream,buf);

//readed should equal buffer size
if(readed != buf.length) {
 throw new RuntimeException("Read bytes count and entry size differ");
}

String string = new String(buf, StandardCharsets.UTF_8);