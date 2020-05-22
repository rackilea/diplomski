for (Object o: query.getResultList()) {         
      Garbage tmpG = new Garbage();
      tmpG.setFilename(o[0]);          
      tmpG.setDescription(o[1]);
      tmpG.setUploadDate(o[2]);

      gList.add(tmpG);
    }