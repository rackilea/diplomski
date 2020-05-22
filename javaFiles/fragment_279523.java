StringWriter sw = new StringWriter();
    JcaPEMWriter pemWriter = new JcaPEMWriter(sw);
    pemWriter.writeObject(req2);
    pemWriter.close();

    PEMParser pemParser = null;
    try
    {
       pemParser = new PEMParser(new StringReader(sw.toString()));
       Object parsedObj = pemParser.readObject();
       System.out.println("PemParser returned: " + parsedObj);
       if (parsedObj instanceof PKCS10CertificationRequest)
       {
          JcaPKCS10CertificationRequest jcaPKCS10CertificationRequest = new JcaPKCS10CertificationRequest((PKCS10CertificationRequest)parsedObj);
          System.out.println("" + jcaPKCS10CertificationRequest.getPublicKey());
       }
    }
    catch (IOException ex)
    {
       ex.printStackTrace();
    }
    finally
    {
       if (pemParser != null)
       {
          pemParser.close();
       }
    }