@WebServlet("/path")
public class Test extends HttpServlet {
    //avoid declaring it here unless it's final
    //JSONObject json = new JSONObject();

    public void init() throws ServletException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        //check that now JSONObject was moved as local variable
        //for this method and it's initialized with the result
        //of a method called retrieveData
        //in this way, you gain several things:
        //1. Reusability: code won't be duplicated along multiple classes
        //   clients of this service
        //2. Maintainability: centralize how and from where you will
        //   retrieve the data.
        JSONObject json = retrieveData();

        response.setContentType("application/json");
        String output = json.toString();
        PrintWriter writer = response.getWriter();
        writer.write(output);
        writer.close();
    }

    //this method will be in charge to return the data you want/need
    //for learning purposes, you're hardcoding the data
    //in real world applications, you have to retrieve the data
    //from a datasource like a file or a database
    private JSONObject retrieveData() {
        //Initializing the object to return
        JSONObject json = new JSONObject();
        //filling the object with data
        //again, you're hardcoding it for learning/testing purposes
        //this method can be modified to obtain data from
        //an external resource
        json.put("city", "Mumbai");
        json.put("country", "India");
        //returning the object
        return json;
    }

    public void destroy() {
        //do nothing
    }
}