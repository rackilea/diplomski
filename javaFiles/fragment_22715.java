try {
    mongo.getAddress();
} catch (Exception e) {
    System.out.println("Database unavailable!");
    mongo.close();
    return;
}