List<Message> messageStorage = new ArrayList<>(); // messageStorage.getAll()
String userChoice = "";
while (!userChoice.equalsIgnoreCase("No")) {
    messageStorage = filterMessages(messageStorage); // modifying the existing list
    System.out.println("Want to continue filtering? Yes/No");
    userChoice = scanner.next();
}