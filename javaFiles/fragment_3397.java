public static void main(String args[]) throws IOException {
        String stringUrl = "url";
        URL url = new URL(stringUrl);
        URLConnection uc = url.openConnection();
        uc.setRequestProperty("X-Requested-With", "Curl");
        String userpass = "username" + ":" + "password";
        String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
        uc.setRequestProperty("Authorization", basicAuth);
        StringBuilder html = new StringBuilder();
        BufferedReader input = null;
        try {
          input = new BufferedReader(new InputStreamReader(uc.getInputStream()));
          String htmlLine;
          while ((htmlLine = input.readLine()) != null) {
            html.append(htmlLine);
          }
        }
        catch (IOException e) {
          e.printStackTrace();
        }
        finally {
          try {
            input.close();
          }
          catch (IOException e) {
            e.printStackTrace();
          }
        }
        System.out.println(html.toString());
    }