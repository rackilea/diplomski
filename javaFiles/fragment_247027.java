private File uploadFolder;

@Override
public void init() throws ServletException {
    uploadFolder = new File("D:\\dev\\uploadservlet\\web\\uploads");
}