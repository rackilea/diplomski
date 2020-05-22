public class FileWriterHandler extends SimpleChannelHandler {
    private final String filename;

    public FileWriterHandler(String filename) {
        this.filename = filename;
    }

    @Override
    public void messageReceived(ChannelHandlerContext context, MessageEvent event) throws Exception{
        ChannelBuffer buffer = (ChannelBuffer)event.getMessage();
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filename, true)
            buffer.readBytes(out, buffer.readableBytes());
        } finally {
            if (out != null) out.close();
        }
    }
}