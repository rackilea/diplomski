final BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream());
new Thread(new Runnable() {
    String line ;
    while ((line = reader.readLine()) != null) {
        interfaceObject.informListener(line);
    }
}).start();