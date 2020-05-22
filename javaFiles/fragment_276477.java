public static void main(final String... args)
        throws IOException {
    try ( final JsonReader jsonReader = getPackageResourceJsonReader(Q43893428.class, "foo.json") ) {
        final Foo foo = gson.fromJson(jsonReader, Foo.class);
        for ( final Peer peer : foo.peers ) {
            System.out.println(peer.fullAddress);
        }
        System.out.println(gson.toJson(foo));
    }
}