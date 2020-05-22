protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {        
    try {
        response.setContentType("application/x-java-serialized-object");
        // read a String-object from applet
        // instead of a String-object, you can transmit any object, which
        // is known to the servlet and to the applet
        InputStream in = request.getInputStream();
        ObjectInputStream inputFromApplet = new ObjectInputStream(in);
        GameInfo score = (GameInfo) inputFromApplet.readObject();
        System.out.println(score.getScore());

        GameInfo info = score;

        if (info.getUserId() > 0) {
            Scores instance = new Scores();
            instance.submitScore(info);
        }

        OutputStream outstr = response.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outstr);
        oos.writeObject("reply");
        oos.flush();
        oos.close();
    } catch (ClassNotFoundException ex) {
    }
}