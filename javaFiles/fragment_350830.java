MimeBodyPart[] mimePart = new MimeBodyPart[itemsToAttach.length];

     String filename; //hold the current path
     FileDataSource resource;//object to grab the physical resource

     for(int i = 0; i < itemsToAttach.length; i++)
        {
        mimePart[i] = new MimeBodyPart();
         filename = itemsToAttach[i];
         System.out.println("Test: " + itemsToAttach[i]);//#############################test only

         resource = new FileDataSource(filename);

         mimePart[i].setDataHandler(new DataHandler(resource));

         mimePart[i].setFileName(filename);//###########fix the long ugly name


         multipart.addBodyPart(mimePart[i]);
         System.out.println("multipart contents: " + multipart.toString());
     }