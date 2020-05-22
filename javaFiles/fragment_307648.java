StringBuilder sb = new StringBuilder();

    String line;
    br = new BufferedReader(new InputStreamReader(is));
    while ((line = br.readLine()) != null) {
        sb.append(line);
    }