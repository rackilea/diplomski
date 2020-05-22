String S = "username1";
   StringBuilder contentBuilder = new StringBuilder();
    try (Stream<String> stream = Files.lines( Paths.get("C:\\Users\\boung\\Desktop\\usernames.txt"), StandardCharsets.UTF_8))
    {
        stream.forEach(s -> contentBuilder.append(s).append("\n"));
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
    if (contentBuilder.toString().contains(S)) {
        System.out.println("username1 found"); 
    }

    ```