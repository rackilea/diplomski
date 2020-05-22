public void generateProductList(HttpServletResponse response) {
    OutputStream os = response.getOutputStream();
    // This is where you would massage the data into the response type you want
    String responseBody = generateResponseBody(productList);
    os.write(responseBody.getBytes());
    os.flush();
}