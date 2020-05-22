StringBuilder content = new StringBuilder();
    try {
        BufferedReader in = new BufferedReader(new FileReader("linkToYourPage.html"));
        String str;
        while ((str = in.readLine()) != null) {
            content.append(str);
        }
        in.close();
    } catch (IOException e) {
    }
String contentText = content.toString();