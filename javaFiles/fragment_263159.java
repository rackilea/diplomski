try {
    in = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

    while ((input = in.readLine()) != null) {
        requestHeaders.add(input);
        System.out.println(input);
    }