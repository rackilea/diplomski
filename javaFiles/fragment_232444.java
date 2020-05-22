public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    PrintWriter out = response.getWriter();

    StringBuilder builder = new StringBuilder();
    BufferedReader reader = request.getReader();
    String line;
    while ((line = reader.readLine()) != null) {
        builder.append(line);
    }

    String jsonString = builder.toString(); // get the json from client
    UrlDto urlDto = new Gson().fromJson(UrlDto.class,jsonString); // parse you json to Java object
    String yourUrl = urlDto.getUrl();
    out.print(yourUrl); // **Set the response text**
    out.close();