Bundle bundle=new Bundle();
bundle.putByteArray("object_attachment", byteArray); // object attachment must be either byteArray
bundle.putString("message","message_to_the_post");

GraphRequest graph =new GraphRequest(pageAccessToken,
    "/<page_id>/photos",//
    bundle,
    HttpMethod.POST,
    new GraphRequest.Callback() {
        @Override
        public void onCompleted(GraphResponse graphResponse)
        {
            //Do stuff here
        }
    });

graph.executeAsync();