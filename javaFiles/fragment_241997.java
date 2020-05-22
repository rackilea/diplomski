ByteArrayOutputStream out = new ByteArrayOutputStream (  );
 JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder ( out );
 JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam ( bi);
 param.setQuality ( 0.3f, false );  
 encoder.setJPEGEncodeParam ( param );
 encoder.encode (bi);
 out.close(); // a no-op on ByteArrayOutputStream
 byte[] data = out.toByteArray();