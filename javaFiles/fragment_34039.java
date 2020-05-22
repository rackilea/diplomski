try(AsynchronousFileChannel asyncfileChannel = AsynchronousFileChannel.open(Paths.get("/Users/***/Documents/server_pull/system_health_12_9_TestServer.json"), StandardOpenOption.READ)){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        ByteBuffer attachment = ByteBuffer.allocate(1024);
        asyncfileChannel.read(buffer, 0, attachment, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("result = " + result);

                attachment.flip();
                byte[] data = new byte[attachment.limit()];
                attachment.get(data);
                System.out.println(new String(data));
                attachment.clear();
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {

            }
        });
    }catch(Exception e){
        e.printStackTrace();
    }