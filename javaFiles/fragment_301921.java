int length;
  while (true) {
        length = inputStream.read(buffer);
        String command = new String(buffer, 0, length);
        System.out.println(command);
    }