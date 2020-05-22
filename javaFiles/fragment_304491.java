if (request instanceof HttpEntityEnclosingRequest) {
    HttpEntity entity = ((HttpEntityEnclosingRequest) request).getEntity();
    if (entity != null) {
    Log.v("RequestBody", EntityUtils.toString(entity, "UTF-8"));
    entity.consumeContent();
    }
    }