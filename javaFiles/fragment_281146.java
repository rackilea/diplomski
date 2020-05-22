protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {       

PrintWriter out = response.getWriter();
String usuario = request.getParameter("nombre");
String password = request.getParameter("apellido");

try {
    CallableStatement cl = Conexion.getConexion().prepareCall("{call SGVC_Login(?,?)}");
    cl.setString(1, usuario);
    cl.setString(2, password);
    ResultSet rs = cl.executeQuery();
    if (rs.next()) {

        HttpSession sesionLoguin = request.getSession();
        sesionLoguin.setAttribute("perfil", rs.getString(12));
        sesionLoguin.setAttribute("nom", rs.getString(5));
        sesionLoguin.setAttribute("apePaterno", rs.getString(3));
        sesionLoguin.setAttribute("apeMaterno", rs.getString(4));
        sesionLoguin.setAttribute("codUser", rs.getString(1));

        if (sesionLoguin.getAttribute("perfil").equals("TVENTA") || sesionLoguin.getAttribute("perfil").equals("TCOBRANZA")) {

            response.setContentType("text/html; charset=iso-8859-1");
            out.write("principal1");         

        } else {
            response.setContentType("text/html; charset=iso-8859-1");
            out.write("principal2");
        }

    } else {
        response.setContentType("text/html; charset=iso-8859-1");
        out.write("error");

    }

} catch (Exception e) {
    System.err.println("error " + e);
}