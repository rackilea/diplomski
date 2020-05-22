import com.google.protobuf.ByteString;

...

GqlQuery.Builder query = GqlQuery.newBuilder().setQueryString(q);
query.addNameArgBuilder()
    .setName("cursor")
    .setCursor(ByteString.EMPTY);