consumer.setMessageListener(listner);

    try {
        System.in.read();
    } catch (IOException e) {
        e.printStackTrace();
    }

    connection.close();