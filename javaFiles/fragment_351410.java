findAll.forEach (new Block <Document> () {
    @Override
    public void apply (Document document) {
        String name = document.getString ("name")! = null? document.getString( "name") : "";
        int age = document.getInteger ( "age", 0);

        // Get the info subdocument
        Document info = document.get("info", Document.class);
        String email = "";
        String phone = "";
        if (info != null) {
          email = info.getString ("email")! = null? info.getString("email") : "";
          phone = info.getString ("phone")! = null? info.getString("phone") : "";
        }
        Costumer costumer = new Costumer (name, age, email, phone);
        System.out.println(costumer);
    }
});