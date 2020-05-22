private URLConnection getServletConnection()
        throws MalformedURLException, IOException {
    URL urlServlet = new URL("http://localhost:8080/GamePortal/submitScore");
    URLConnection con = urlServlet.openConnection();
    con.setDoOutput(true);
    con.setRequestProperty(
            "Content-Type",
            "application/x-java-serialized-object");
    return con;

}

private void onSendData(GameInfo info) {

    try {
        // send data to the servlet
        URLConnection con = getServletConnection();
        OutputStream outstream = con.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outstream);
        oos.writeObject(info);
        oos.flush();
        oos.close();
        // receive result from servlet
        InputStream instr = con.getInputStream();
        ObjectInputStream inputFromServlet = new ObjectInputStream(instr);
        String result = (String) inputFromServlet.readObject();
        //JOptionPane.showMessageDialog(null, result);
        inputFromServlet.close();
        instr.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}