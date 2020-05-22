doRead(SelectionKey key){
  //here we retrieve the key we attached earlier, so we now what to do / wheer the data is coming from
  MyIdentifierType myIdentifier = (MyIdentifierType)key.attachment();
  //This is then used to get back to the SocketChannel and Read the Data
  myIdentifier.readTheData();
}