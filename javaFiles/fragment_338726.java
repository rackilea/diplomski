BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                            conn.getInputStream()));

String inputLine;

while ((inputLine = ic.readLine()) != null) 
    System.out.println(inputLine);
in.close();