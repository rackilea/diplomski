try {
      ApplicationState state = new ApplicationState();
      ...
      // File to serialize object to
      String fileName = "applicationState.ser";

      // New file output stream for the file
      FileOutputStream fos = new FileOutputStream(fileName);

      // Serialize String
      SerializationUtils.serialize(state, fos);
      fos.close();

      // Open FileInputStream to the file
      FileInputStream fis = new FileInputStream(fileName);

      // Deserialize and cast into String
      String ser = (String) SerializationUtils.deserialize(fis);
      System.out.println(ser);
      fis.close();
    } catch (Exception e) {
      e.printStackTrace();
    }