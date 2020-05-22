// Prepare the HTTP request.
            FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, uriJson.toASCIIString());
          request.headers().set(CONTENT_TYPE, "text/plain; charset=UTF-8");

            ByteBuf  buf = Unpooled.copiedBuffer(data, CharsetUtil.UTF_8);
            request.content().writeBytes(buf);
            request.headers().set(CONTENT_LENGTH,request.content().readableBytes());