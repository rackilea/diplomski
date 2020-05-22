private static final short apiKey = ApiKeys.CREATE_TOPICS.id;
    private static final short version = 0;
    private static final short correlationId = -1;

private static CreateTopicsResponse createTopic(CreateTopicsRequest request, String client) throws IllegalArgumentException, IOException {
        String[] comp = client.split(":");
        if (comp.length != 2) {
            throw new IllegalArgumentException("Wrong client directive");
        }
        String address = comp[0];
        int port = Integer.parseInt(comp[1]);

        RequestHeader header = new RequestHeader(apiKey, version, client, correlationId);
        ByteBuffer buffer = ByteBuffer.allocate(header.sizeOf() + request.sizeOf());
        header.writeTo(buffer);
        request.writeTo(buffer);

        byte byteBuf[] = buffer.array();

        byte[] resp = requestAndReceive(byteBuf, address, port);
        ByteBuffer respBuffer = ByteBuffer.wrap(resp);
        ResponseHeader.parse(respBuffer);

        return CreateTopicsResponse.parse(respBuffer);
    }

    private static byte[] requestAndReceive(byte[] buffer, String address, int port) throws IOException {
        try(Socket socket = new Socket(address, port);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream())
        ) {
            dos.writeInt(buffer.length);
            dos.write(buffer);
            dos.flush();

            byte resp[] = new byte[dis.readInt()];
            dis.readFully(resp);

            return resp;
        } catch (IOException e) {
            log.error(e);
        }

        return new byte[0];
    }