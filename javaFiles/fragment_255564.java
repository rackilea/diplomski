@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    @EJB
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = productService.find(request.getParameter("id"));
        request.setAttribute("product", product); // Will be available as ${product} in JSP
        request.getRequestDispatcher("/WEB-INF/product.jsp").forward(request, response);
    }

}