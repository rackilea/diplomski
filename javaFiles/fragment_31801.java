InputStream is = pr.getInputStream();
InputStreamReader isr = new InputStreamReader(is);
BufferedReader br = new BufferedReader(isr);

String line;
while ((line = br.readLine()) != null){
    System.out.println("MSG: " + line);
}