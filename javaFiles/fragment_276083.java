OutputStream os = conn.getOutputStream();
os.write(input.getBytes()); // The input you need to pass to the webservice
os.flush();
...
BufferedReader br = new BufferedReader(new InputStreamReader(
        (conn.getInputStream()))); // Getting the response from the webservice

String output;
System.out.println("Output from Server .... \n");
while ((output = br.readLine()) != null) {
    System.out.println(output); // Instead of this, you could append all your response to a StringBuffer and use `toString()` to get the entire JSON response as a String.
    // This string json response can be parsed using any json library. Eg. GSON from Google.
}