class Util {
    long a = -1;
    String str = null;
    responseJSON = null;

    String someMethod();
}

protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

    //initialization of pojo goes here
    Util pojo = new Util();
    pojo .a = request.getParameter("serial_number");
    pojo .str = this.utilMethod();
    .... pojo.someMethod();

     //and the rest of the code goes here
     PrintWriter pout = new PrintWriter();
     pout.write("Success!");
 }

 protected String utilMethod () {

     //this returns some string after executiion
 }