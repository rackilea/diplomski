if (request.getMethod().equals(HttpMethod.POST)) {
                    decoder = new HttpPostRequestDecoder(dataFactory, request);
                    decoder.setDiscardThreshold(0);
if (decoder != null) {
        if (msg instanceof HttpContent) {
            HttpContent chunk = (HttpContent) msg;
            decoder.offer(chunk);
            readChunk(channelHandlerContext);
            if (chunk instanceof LastHttpContent) {
                resetPostRequestDecoder();
            }
        }
    }
private void readChunk(ChannelHandlerContext ctx) throws IOException {
    while (decoder.hasNext()) {
        InterfaceHttpData data = decoder.next();
        if (data != null) {
            try {
                switch (data.getHttpDataType()) {
                    case Attribute:
                        break;
                    case FileUpload:    
                        FileUpload fileUpload = (FileUpload) data;
                        File file = new File("C:\\test\\" + fileUpload.getName);
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        try (FileChannel inputChannel = new FileInputStream(fileUpload.getFile()).getChannel(); FileChannel outputChannel = new FileOutputStream(file).getChannel()) {
                            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
                            sendSimpleResponse(ctx,CREATED,"file name: " +file.getAbsolutePath());
                        }
                        break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                data.release();
            }
        }
    }
}

private void resetPostRequestDecoder() {
    request = null;
    decoder.destroy();
    decoder = null;
}