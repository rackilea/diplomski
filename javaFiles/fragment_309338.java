String input = "Hello today is 01/17 current time is 03:20 humidity is 50%.";
String[] parts = input.split("\\s+");
for (String part : parts) {
    if (part.matches(".*\\d+.*")) {
        System.out.println(part);
    }
}