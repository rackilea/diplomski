public class TableAppend extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TableAppend() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        response.setCharacterEncoding("UTF-8");
        response.setContentType("UTF");
        PrintWriter out = response.getWriter();

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String json ="";
        System.out.println("-----------------");
        if(name != null && age != null){
            TableAppendPojo obj = new TableAppendPojo();
            obj.setName(name);
            obj.setAge(age);

            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(obj);
            System.out.println("json : "+json);
        }
        out.println(json);
    }

}