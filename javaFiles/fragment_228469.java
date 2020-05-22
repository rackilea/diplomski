MimeMessage payload = (MimeMessage) message.getPayload();
    Multipart mp = (Multipart) payload.getContent();
    for (int i = 0; i < mp.getCount(); i++) {
                        BodyPart bodyPart = mp.getBodyPart(i);
                        StringWriter writer = new StringWriter();
                        IOUtils.copy(bodyPart.getInputStream(), writer);
                        System.out.println("Content inputstream: " +  writer.toString());


    }