public InputStream newCert(@FormParam("username") String uname,
        @FormParam("name") String CommonName,
        @FormParam("email") String email,
        @FormParam("pictureURL") String pURL,
        @FormParam("spkac") String spkacData) {

  ...

  ByteArrayOutputStream bout = null;
  InputStream is = null;

  ...

  try {...}
  catch {...}

  is = new ByteArrayInputStream (bout.toByteArray());   
  return is;

}