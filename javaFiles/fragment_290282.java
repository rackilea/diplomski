public class CategoryServlet extends HttpServlet {

/**
 * serialization
 */
private static final long serialVersionUID = -2461387206258395143L;

private static final Logger LOGGER = Logger
        .getLogger(CategoryServlet.class);

private Connection connection = null;

public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    connection = DBConnection.getConnection();

    RequestDispatcher dispatcher = request
            .getRequestDispatcher("jsp/pages/create.jsp");
    dispatcher.include(request, response);

    String id = request.getParameter("id");
    String category = request.getParameter("category");
    String parentCategory = request.getParameter("parentCategory");

    if (StringUtils.paramSet(id)) {

        request.setAttribute("CATEGORY", CategoryService.getCategoryById(
                Long.valueOf(id), connection));

    } else if (StringUtils.paramSet(parentCategory)) {

        request.setAttribute(
                "CATEGORY",
                CategoryService.getParentCategory(
                        Integer.valueOf(parentCategory), connection));

    } else if (StringUtils.paramSet(category)) {
        String categories = request.getParameter("category");
        if (StringUtils.paramSet(categories)) {
            request.setAttribute(
                    "CATEGORY",
                    CategoryService.listAllCategory(
                            Integer.valueOf(parentCategory), connection));
        }
        dispatcher = request.getRequestDispatcher("jsp/pages/create.jsp");
    } else {
        request.setAttribute(
                "CATEGORY",
                CategoryService.listAllCategory(
                        Integer.valueOf(parentCategory), connection));

    }
    dispatcher.include(request, response);

    DBConnection.closeConnection(connection);
}

public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    int parentCategory = Integer.parseInt(request.getParameter("parentCategory"));

    LOGGER.info("parentCategory id : " + parentCategory);

        connection = DBConnection.getConnection();

        Map<String, List<Category>> resp = new HashMap<String, List<Category>>();

        List<Category> categorySelectorList = CategoryService
                .listAllCategory(parentCategory,
                        connection);

        resp.put("categorySelectorList", categorySelectorList);

        response.setContentType("application/json");

        try {
            Gson gson = new Gson();
            String s = gson.toJson(resp);
            response.getWriter().write(s);

            LOGGER.info("TESTING mmmm : " + s);

        } catch (Exception e) {

            response.getWriter()
                    .write("{\"error\" : \"An error occured please try again. If the error persists, please refresh your browser \"}");
        }
        DBConnection.closeConnection(connection);
    }