ByteArrayOutputStream bArrOS = new ByteArrayOutputStream();
    // reqEntity is the MultipartEntity instance
    reqEntity.writeTo(bArrOS);
    bArrOS.flush();
    ByteArrayEntity bArrEntity = new ByteArrayEntity(bArrOS.toByteArray());
    bArrOS.close();

    bArrEntity.setChunked(true);
    bArrEntity.setContentEncoding(reqEntity.getContentEncoding());
    bArrEntity.setContentType(reqEntity.getContentType());

    // Set ByteArrayEntity to HttpPost
    post.setEntity(bArrEntity);