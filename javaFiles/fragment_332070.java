@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Product> products = someProductService.list();

    request.setAttribute("products", products);
    request.getRequestDispatcher("/WEB-INF/xml/products.jsp").forward(request, response);
}