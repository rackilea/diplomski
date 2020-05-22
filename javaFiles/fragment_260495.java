private void fixHeader(HttpServletResponse response) {
    response.addHeader("Access-Control-Allow-Origin", "http://localhost:8383");
    response.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, OPTIONS, DELETE");
    response.addHeader("Access-Control-Allow-Headers", "Content-type");
    response.addHeader("Access-Control-Max-Age", "86400");
    response.addHeader("Access-Control-Request-Headers", "X-Requested-With, accept, content-type");
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws     ServletException, IOException {
    fixHeader(response);
}

@Override
protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    fixHeader(resp);
}