public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    StringBuilder json = new StringBuilder();
    String str;
    while ((str = request.getReader().readLine()) != null) {
        json.append(str);
    }

    // Using Jackson
    ObjectMapper objectMapper = new ObjectMapper();
    Bean bean = objectMapper.readValue(json.toString(), Bean.class);

    System.out.println("Year ::" + bean.getYear());
    System.out.println("Dosage ::" + bean.getDosage());
}