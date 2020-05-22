JcaMiscPEMGenerator generator = new JcaMiscPEMGenerator(kg.getPrivateKey());
  stringWriter = new StringWriter();
  pemWriter = new PemWriter(stringWriter);
  pemWriter.writeObject(generator.generate());
  pemWriter.close();
  pemString = stringWriter.toString();
  kg.writeToFile(PRIVATE_KEY_PATH, pemString.getBytes());