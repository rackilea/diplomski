public void welcomeUser() {
    System.out.println("You can choose from these blocks:");
    for (int index = 0; index < categories.size(); index++) { 
        Category category = categories.get(index);
        System.out.println("[" + (index+1) + "." + category.getTitle() + "]");
    }
    // ...
}