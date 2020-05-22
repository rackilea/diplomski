Multipart multipart = (Multipart) messages[i].getContent();

    for (int j = 0; j < multipart.getCount(); j++) {

        BodyPart bodyPart = multipart.getBodyPart(j);

        String disposition = bodyPart.getDisposition();

          if (disposition != null && (disposition.equalsIgnoreCase("ATTACHMENT"))) { // BodyPart.ATTACHMENT doesn't work for gmail
              System.out.println("Mail have some attachment");

              DataHandler handler = bodyPart.getDataHandler();
              System.out.println("file name : " + handler.getName());                                 
            }
          else { 
              System.out.println("Body: "+bodyPart.getContent());
              content= bodyPart.getContent().toString();
            }