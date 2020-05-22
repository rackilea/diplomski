public void handle(String target, HttpServletRequest request,
                   HttpServletResponse response, int dispatch)
       throws IOException {
  // Scan request into a string
  Scanner scanner = new Scanner(request.getInputStream());
  StringBuilder sb = new StringBuilder();
  while (scanner.hasNextLine()) {
    sb.append(scanner.nextLine());
  }
  response.getOutputStream().println("This is servlet response");
}