final ContentProvider provider = request.getContent();
final Iterator<ByteBuffer> it = provider.iterator();
while (it.hasNext()) {
    final ByteBuffer next = it.next();
    final byte[] bytes = new byte[next.capacity()];
    next.get( bytes );
    // Should by "payload"
    String content = new String( bytes, Charset.forName( "UTF-8" ) );
}