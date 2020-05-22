try (InputStream is = new InflaterInputStream(new FileInputStream(destFile))) {

    // read the stream a single byte each time until we encounter '\0'
    int aByte = 0;
    while ((aByte = is.read()) != -1) {
        if (aByte == '\0') {
            break;
        }
    }

    // from now on we want to print the data
    BufferedReader b = new BufferedReader(new InputStreamReader(is, "UTF8"));
    String line = null;
    while ((line = b.readLine()) != null) {
        System.out.println(line);
    }
    b.close();         

} catch(IOException e) { // handle }