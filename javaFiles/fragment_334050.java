@Consumes(MediaType.APPLICATION_JSON)
    public void addBook(JsonObject data) {

        int id = Integer.parseInt(data.getString("bid"));
        String title = data.getString("title");
        double price = Double.parseDouble(data.getString("price"));

        System.out.println(id+" "+title+" "+price);