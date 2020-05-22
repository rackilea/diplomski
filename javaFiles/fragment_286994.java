String passwordData = jsonData.getAsString();
if (passwordData.equals(password)) {
    System.out.println("Login successful");
} else {
    System.out.println("Login unsuccessful");
}