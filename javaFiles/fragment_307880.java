String inputText = "I want to know relating to cloud based erp services.";
Set<String> words = new HashSet<String>();
words.add("erp");
words.add("cloud");

if (words.stream().filter(s -> inputText.contains(s)).count() == words.size()) {
    System.out.println("Yes we providing it.");
} else {
    System.out.println("No, we are not providing it.");
}