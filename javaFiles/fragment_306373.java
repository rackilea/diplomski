class Template extends HttpServlet {
    doGet()
    {
        write getHeader();
        write getMenu();
        write getBody();
    }
}

class SamplePage extends Template {
    getBody()
    {
        //put body HTML here
    }
}