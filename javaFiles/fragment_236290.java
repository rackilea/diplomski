ObjectInputStream dataInput = new ObjectInputStream(request.getInputStream());
    String param = dataInput.readUTF();

    dataInput.close();

    String[] values = param.split("%");