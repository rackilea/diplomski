protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

String zAPIInputStringP = "";

BufferedReader in = new BufferedReader(new InputStreamReader(
                request.getInputStream()));
String line = in.readLine();
while (line != null) {
    zAPIInputStringP += line;
    line = in.readLine();
}


}