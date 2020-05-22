URL helloServletURL = new URL(getCodeBase().toString() + "mydb");
    URLConnection urlConnection = helloServletURL.openConnection();
    urlConnection.setDoInput(true);
    urlConnection.setDoOutput(true);
    urlConnection.setUseCaches(false);

    String param1 = "data1";
    String param2 = "data1";
    String param3 = "data1";

    ObjectOutputStream objOut = new ObjectOutputStream(urlConnection.getOutputStream());
    objOut.writeUTF(param1 + "%" + param2 + "%" + param3);

    objOut.flush();