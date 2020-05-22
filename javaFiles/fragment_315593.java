byte[] bytes = "127".getBytes();

    String value = "";
    for (byte part : bytes) {

        value += (char)part;
    }

    System.out.print(value); // 127