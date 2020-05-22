private void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    try (PrintWriter writer = response.getWriter()) {
        System.out.println(request.getQueryString());
        String[] parms = request.getQueryString().split(";");
        String outData = "";
        /*
         * algorithm for generate out data
         */
        writer.println(outData);
    }
}