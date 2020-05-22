for (Map.Entry<String, String> entry : map.entrySet()) {
    if (userInput.contains(entry.getKey())) {
        userInput = userInput.replaceAll(entry.getKey(), entry.getValue());
    }
}
System.out.println("Converted string  - " + userInput);