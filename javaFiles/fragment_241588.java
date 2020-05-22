BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"), 8);
    StringBuilder sb = new StringBuilder();
    String line = null;
    while ((line = reader.readLine()) != null) { 
        sb.append(line + "\n"); 
    }
    result = sb.toString();
    System.out.println(result);// It will print you the value
    is.close();