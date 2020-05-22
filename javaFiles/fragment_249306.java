for (Document document: documents) {
    String name = searchQuery.getString("name");
    Boolean booleanValue = document.getBoolean("booleanValue");
        System.out.println(document);
    System.out.println(name);
    System.out.println(booleanValue);
}