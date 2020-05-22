BufferedReader in = null;
    StringBuilder sb = new StringBuilder();
    try {
        in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
        String input = null;
        while((input=in.readLine())!=null) {
            sb.append(input);
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if(in!=null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    String serverMsg = sb.toString();