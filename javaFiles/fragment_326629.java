BufferedReader in = null;
    try {
        String line;
        in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while ((line = in.readLine()) != null) {
            result += line;
        }
    } finally {
        if (in != null) {
            in.close();
        }
    }