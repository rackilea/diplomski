S3AsyncClient client = S3AsyncClient.create();

GetObjectRequest getObjectRequest = GetObjectRequest.builder().bucket("my-bucket").key("my-object-key").build();

client.getObject(getObjectRequest, AsyncResponseTransformer.toBytes())
      .thenApply(ResponseBytes::asUtf8String)
      .whenComplete((stringContent, exception) -> {
          if (stringContent != null)
              System.out.println(stringContent);
          else
              exception.printStackTrace();
      });