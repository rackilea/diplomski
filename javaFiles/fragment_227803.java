public class AbcServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        byte[] read = URLReader.read("pl", "en", "ko\u0144");
        resp.getOutputStream().write(read) ;
    }
}