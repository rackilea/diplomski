client.connect(data.getAddress(), data.getPort());
try {
    client.register(data.getUserName());
} catch( DuplicateNameException e ) {
    data.setError( "Name already taken" );
    data.show();
    return;
}