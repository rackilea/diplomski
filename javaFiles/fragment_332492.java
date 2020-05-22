public String cryptMdp(String mdp){
    try {
        URL url = new URL("http://myaddress/someproject/create_pwd.php?pwd=" + mdp);
        URLConnection conn = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String inputline = "";

        while((inputline = in.readLine()) != null){
            return inputline;
        }
        in.close();
    } catch (MalformedURLException ex) {
        System.out.println("error URL");
    } catch (IOException ex) {
        System.out.println("error connection");
    }
    return null;
}