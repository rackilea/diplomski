while ((sentence = br.readLine()) != null) {
        outToServer.writeBytes(sentence + "\r\n\r\n");
        outToServer.flush();
        System.out.println(">" + sentence);
        while ((sentence = inFromServer.readLine()) != null)
            System.out.println("< " + sentence);
    }