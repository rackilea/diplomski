try {
     serializer.read(REQ.class, reader);
}
catch(Exception ex) {
     Log.i(TAG, ex.getCause().getMessage());
}