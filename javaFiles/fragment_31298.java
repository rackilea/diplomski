for (int i = 0; i < message.length(); i++) {
                    char c = message.charAt(i);
                    String bereit = Integer.toHexString(c);
                    System.out.println(bereit);
                    byte[] send = bereit.getBytes();
                    connected.write(send);
                    //connected.write(abschluss);
    }